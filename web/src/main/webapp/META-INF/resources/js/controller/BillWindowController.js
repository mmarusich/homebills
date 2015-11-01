Ext.define('HomeBills.controller.BillWindowController', {
    extend: 'Ext.app.Controller',
    views: ['BillWindowView'],
    stores: [
        'ProductStore'
    ],
    refs: [
        {
            ref: 'window',
            selector: 'billwindow'
        },
        {
            ref: 'productCombo',
            selector: 'billwindow combo[itemId=productCombo]'
        },
        {
            ref: 'categoryList',
            selector: 'categorylist'
        }
    ],
    init: function () {
        var me = this;
        me.listen({
            component: {
                'billwindow button[action=addProduct]': {
                    click: me.onAddProductButtonClick
                },
                'productwindow': {
                    create: me.onProductCreate
                },
                'billwindow button[action=saveBill]': {
                    click: me.onSaveBillButtonClick
                }
            },
            store: {}
        });
        me.callParent(arguments);
    },
    onSaveBillButtonClick: function () {
        var me = this,
            window = me.getWindow();
        if(window.isValid()){
            window.el.mask('Создание...');
            var value = window.getValue();
            var model = Ext.create('HomeBills.model.BillModel', value);
            model.set('categoryId', me.getCategoryId());
            model.save({
                callback: function (records, operation, success) {
                    window.el.unmask();
                    if (success) {
                        window.fireEvent('create', window, model);
                        window.close();
                    } else {
                        window.el.unmask();
                    }
                }
            });
        }

    },
    onAddProductButtonClick: function () {
        Ext.create('HomeBills.view.ProductWindowView').show();
    },
    onProductCreate: function (window, model) {
        var me = this;
        me.getStore('ProductStore').add(model);
        me.getProductCombo().select(model);
    },
    getCategoryId: function () {
        var me = this,
            categoryList = me.getCategoryList();
        return categoryList.getSelectionModel().getSelection()[0].getId();
    }
})
