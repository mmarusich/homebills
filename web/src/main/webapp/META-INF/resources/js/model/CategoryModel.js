Ext.define('HomeBills.model.CategoryModel', {
    extend : 'Ext.data.Model',
    fields : [
        {
            name : 'id',
            type : 'int',
            persist : false
        },
        {
            name : 'name'
        }
    ],
    proxy: {
        type: 'rest',
        url: '/category',
        reader: {
            type: 'json'
        }
    }
})