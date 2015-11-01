Ext.define('HomeBills.view.BillsGrid.js', {
    extend: 'Ext.grid.Panel',
    xtype: 'billsgrid',
    store: 'BillsGridStore',
    title: 'Расходы',
    features: [{
        ftype: 'summary'
    }],
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
                dataIndex: 'name',
                width: 300
            },
            {
                text: 'Дата Покупки',
                dataIndex: 'createDate',
                width: 150
            },
            {
                text: 'Категория',
                dataIndex: 'category',
                width: 200
            },
            {
                text: 'Сума',
                dataIndex: 'cost',
                flex: 1,
                summaryType: 'count',
                summaryRenderer: function (value, summaryData, dataIndex) {
                    return Ext.String.format('{0} student{1}', value, value !== 1 ? 's' : '');
                }
            }
        ]
    }
})
