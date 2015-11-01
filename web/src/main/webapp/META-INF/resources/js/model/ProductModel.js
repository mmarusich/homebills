Ext.define('HomeBills.model.ProductModel', {
    extend : 'Ext.data.Model',
    fields : [
        {
            name : 'id',
            type : 'int',
            persist : false
        },
        {
            name : 'name'
        },
        {
            name : 'categoryId',
            type : 'int'
        }
    ],
    proxy: {
        type: 'rest',
        url: '/product',
        reader: {
            type: 'json'
        }
    }
})