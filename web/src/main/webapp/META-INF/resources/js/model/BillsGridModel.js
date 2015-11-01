Ext.define('HomeBills.model.BillsGridModel', {
    extend : 'HomeBills.model.BillModel',
    fields : [
        {
            name : 'productName'
        },
        {
            name : 'categoryName'
        }
    ],
    proxy: {
        type: 'rest',
        url: '/bill/grid',
        simpleSortMode : true,
        reader: {
            type: 'json'
        }
    }
})