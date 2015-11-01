Ext.define('HomeBills.store.BillsGridStore', {
    extend : 'Ext.data.Store',
    model : 'HomeBills.model.BillsGridModel',
    sorters : [
        {
            property : 'createDate',
            direction : 'DESC'
        }
    ],
    remoteSort : true,
    storeId : 'BillsGridStore',
    pageSize : 100

})