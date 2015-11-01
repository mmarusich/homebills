Ext.define('HomeBills.controller.BillsGridController', {
    extend: 'Ext.app.Controller',
    views: [
        'BillsGrid'
    ],
    stores: [
        'BillsGridStore'
    ],
    refs: [
        {
            ref: 'grid',
            selector: 'billsgrid'
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
                'categorylist': {
                    select: me.onCategoryChange
                },
                'billsgrid button[action=addBill]': {
                    click: me.onAddButtonClick
                },
                'billwindow': {
                    create: me.onBillCreate
                }

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
    onBillCreate: function (window, model) {
        var me = this;

    },
    onAddButtonClick: function () {
        Ext.create('HomeBills.view.BillWindowView').show();
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