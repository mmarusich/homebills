Ext.define('HomeBills.model.BillsGridModel', {
    extend : 'Ext.data.Model',
    fields : [
        {
            name : 'name'
        },
        {
            name : 'createDate'
        },
        {
            name : 'category'
        },
        {
            name : 'cost'
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