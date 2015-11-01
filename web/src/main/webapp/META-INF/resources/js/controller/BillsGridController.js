Ext.define('HomeBills.controller.BillsGridController', {
    extend: 'Ext.app.Controller',
    views: [
        'BillsGrid'
    ],
    stores: [
        'BillsGridStore',
        'ProductStore'
    ],
    refs: [
        {
            ref: 'grid',
            selector: 'billsgrid'
        },
        {
            ref: 'categoryList',
            selector: 'categorylist'
        },
        {
            ref : 'productCombo',
            selector : 'combo[itemId=productCombo]'
        },
        {
            ref : 'addBillWindow',
            selector : 'addbillwindow'
        }
    ],
    init: function () {
        var me = this;
        me.listen({
            component: {
                'categorylist': {
                    select: me.onCategoryChange
                },
                'billsgrid button[action=addBill]': {
                    click: me.onAddButtonClick
                },
                'button[action=addProduct]': {
                    click: me.onAddProductButtonClick
                },
                'button[action=saveBill]': {
                    click: me.onSaveBillButtonClick
                },
            },
            store: {
                '#BillsGridStore': {
                    beforeload: me.beforeLoad
                },
                '#ProductStore': {
                    beforeload: me.beforeLoad
                }

            }
        });
        me.callParent(arguments);
    },
    onSaveBillButtonClick : function(){
       var me = this,
           window = me.getAddBillWindow(),
           productCombo = me.getProductCombo(),
           priceField = window.down('numberfield[name=price]'),
           billDate = window.down('datefield[name=billDate]');
           console.log(productCombo.getValue())
           console.log(priceField.getValue())
           console.log(billDate.getValue())


    },
    onAddProductButtonClick: function () {
        var me = this;
        Ext.create('Ext.window.Window', {
            title: 'Добаление Продукта',
            constrain: true,
            modal: true,
            width: 300,
            bodyPadding: 20,
            layout: {
                type: 'vbox',
                align: 'stretch',
                pack: 'start'
            },
            fbar: [
                '->',
                {
                    xtype: 'button',
                    text: 'Добавить',
                    handler: function () {
                        var window = this.up('window');
                        var field = window.down('textfield');
                        if (field.isValid()) {
                            window.el.mask('Создание...');
                            me.checkProductName(field.getValue(), function(valid){
                                if(valid){
                                    var model = Ext.create('HomeBills.model.ProductModel', {
                                        name: field.getValue(),
                                        categoryId: me.getCategoryId()
                                    });
                                    model.save({
                                        callback: function (records, operation, success) {
                                            window.el.unmask();
                                            if (success) {
                                                me.getStore('ProductStore').add(model);
                                                me.getProductCombo().select(model);
                                                window.close();
                                            }
                                        }
                                    });
                                } else {
                                    field.markInvalid(Ext.String.format('Продукт з именем {0} уже существует', field.getValue()));
                                    window.el.unmask();
                                }
                            })
                        }
                    }
                }
            ],
            items: [
                {
                    xtype: 'textfield',
                    fieldLabel: 'Имя',
                    labelAlign: 'top',
                    allowBlank: false
                }
            ]
        }).show();
    },
    checkProductName: function (value, callback) {
        var me = this;
        Ext.Ajax.request({
            method : 'GET',
            url: 'product/checkName',
            params: {
                categoryId: me.getCategoryId(),
                name: value
            },
            success: function (response) {
                var valid = JSON.parse(response.responseText);
                callback(valid);
            },
            failure: function () {
                callback(false);
            }

        });
    },
    onAddButtonClick: function () {
        var me = this;
        Ext.create('Ext.window.Window', {
            title: 'Добавление Товара',
            constrain: true,
            modal: true,
            width: 350,
            bodyPadding: 20,
            fbar: [
                '->',
                {
                    xtype: 'button',
                    action : 'saveBill',
                    text: 'Добавить'
                }
            ],
            items: [
                {
                    xtype: 'container',
                    layout: {
                        type: 'hbox',
                        align: 'bottom'
                    },
                    items: [
                        {
                            xtype: 'combo',
                            itemId : 'productCombo',
                            fieldLabel: 'Продукт',
                            labelAlign: 'top',
                            store: 'ProductStore',
                            displayField: 'name',
                            valueField: 'id',
                            emptyText : 'Виберите продукт',
                            minChars: 1,
                            required : true,
                            forceSelection : true

                        },
                        {
                            xtype: 'button',
                            text: 'Добавить',
                            margin: '0 10',
                            action: 'addProduct'
                        }
                    ]
                },
                {
                    xtype: 'numberfield',
                    anchor: '100%',
                    name: 'price',
                    labelAlign: 'top',
                    fieldLabel: 'Цена',
                    value: 0.1,
                    minValue: 0.1,
                    margin: '10 0 0 0'
                },
                {
                    xtype: 'datefield',
                    fieldLabel: 'Дата покупки',
                    labelAlign: 'top',
                    value: new Date(),
                    margin: '10 0 0 0',
                    name : 'billDate'
                }

            ],
            getValue : function(){
                var me = this;
                me.
            }

        }).show();
    },
    beforeLoad: function (store, operation) {
        var me = this,
            params = store.proxy.extraParams;
        params.categoryId = me.getCategoryId();
    },
    onCategoryChange: function (view, record) {
        var me = this,
            grid = me.getGrid();
        grid.store.loadPage(1);
    },
    getCategoryId: function () {
        var me = this,
            categoryList = me.getCategoryList();
        return categoryList.getSelectionModel().getSelection()[0].getId();
    }


})