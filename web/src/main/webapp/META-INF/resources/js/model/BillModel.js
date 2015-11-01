Ext.define('HomeBills.model.BillModel', {
    extend : 'Ext.data.Model',
    fields : [
        {
            name : 'id',
            type : 'int',
            persist  : false
        },
        {
            name : 'productId',
            type : 'int'
        },
        {
            name : 'createDate'
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