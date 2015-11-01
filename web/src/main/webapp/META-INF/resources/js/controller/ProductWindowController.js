Ext.define('HomeBills.controller.ProductWindowController', {
    extend: 'Ext.app.Controller',
    views: ['ProductWindowView'],
    refs: [
        {
            ref: 'window',
            selector: 'productwindow'
        },
        {
            ref : 'nameField',
            selector : 'productwindow textfield[name=name]'
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
                'productwindow button[action=addProduct]': {
                    click: me.onAddProductButtonClick
                }
            },
            store: {}
        });
        me.callParent(arguments);
    },
    onAddProductButtonClick: function () {
        var me = this,
            window = me.getWindow();
        var field = me.getNameField();
        if (field.isValid()) {
            window.el.mask('Создание...');
            me.checkProductName(field.getValue(), function (valid) {
                if (valid) {
                    var model = Ext.create('HomeBills.model.ProductModel', {
                        name: field.getValue(),
                        categoryId: me.getCategoryId()
                    });
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
                } else {
                    field.markInvalid(Ext.String.format('Продукт з именем {0} уже существует', field.getValue()));
                    window.el.unmask();
                }
            })
        }
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
    getCategoryId: function () {
        var me = this,
            categoryList = me.getCategoryList();
        return categoryList.getSelectionModel().getSelection()[0].getId();
    }
})
