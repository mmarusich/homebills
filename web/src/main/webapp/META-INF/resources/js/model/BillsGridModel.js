Ext.define('HomeBills.model.BillsGridModel', {
    extend : 'Ext.data.Model',
    fields : [
        {
            name : 'id',
            type : 'int',
            persist  : false
        },
        {
            name : 'productName'
        },
        {
            name : 'productId',
            type : 'int'
        },
        {
            name : 'createDate'
        },
        {
            name : 'categoryName'
        },
        {
            name : 'categoryId',
            type : 'int'
        },
        {
            name : 'cost',
            type : 'auto'
        }
    ],
    proxy: {
        type: 'rest',
        url: '/bill',
        simpleSortMode : true,
        reader: {
            type: 'json'
        }
    }
})