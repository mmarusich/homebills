Ext.define('HomeBills.view.BillsGrid.js', {
    extend: 'Ext.grid.Panel',
    xtype: 'billsgrid',
    store: 'BillsGridStore',
    title: 'Расходы',
    features: [{
        ftype: 'summary'
    }],
    selectionModel : {
        mode : 'SINGLE'

    },
    selType : 'checkboxmodel',
    columnLines: true,
    tbar: {
        padding: 0,
        items: [
            {
                xtype: 'button',
                text: 'Добавить',
                margin: '0 8 0 10',
                action: 'addBill'
            },
            {
                xtype: 'tbseparator'
            },
            {
                xtype: 'pagingtoolbar',
                store: 'BillsGridStore',
                border: 0,
                padding : '6 0',
                dock: 'top'
            }]
    },
    columns: {
        defaults: {
            menuDisabled: true
        },
        items: [
            {
                text: 'Наименование Товара',
                dataIndex: 'productName',
                width: 300
            },
            {
                text: 'Дата Покупки',
                dataIndex: 'createDate',
                width: 150,
                renderer : function(value){
                    return Ext.util.Format.date(new Date(value), 'Y-m-d');
                }
            },
            {
                text: 'Категория',
                dataIndex: 'categoryName',
                width: 200
            },
            {
                text: 'Цена',
                dataIndex: 'cost',
                flex: 1,
                summaryType: 'sum',
                summaryRenderer: function (value, summaryData, dataIndex) {
                    return 'Сума: ' + Ext.util.Format.number(value, '0.00') + ' грн.'
                },
                renderer : function(value){
                    return Ext.util.Format.number(value, '0.00') + ' грн.';
                }
            }
        ]
    }
})
