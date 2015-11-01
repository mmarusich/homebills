Ext.Loader.setConfig({
    enabled: true,
    disableCaching: true
});
Ext.application({
    appFolder: '/js/',
    name: 'HomeBills',
    models: [],
    stores: [],
    controllers: [
        'BillsGridController',
        'CategoryListController',
        'BillWindowController',
        'ProductWindowController'
    ],
    requires: [
        'HomeBills.util.Utils'
    ],
    autoCreateViewport: true,
    launch: function () {
        Ext.QuickTips.init(true, {anchorToTarget: true, constrainPosition: true});
        this.initErrorHandlers();
    },
    initErrorHandlers: function () {
        Ext.Ajax.on('requestcomplete', function (conn, response, options) {
            var resp = Ext.JSON.decode(response.responseText, true);
            if (Ext.isObject(resp) && resp.hasOwnProperty("success") && resp.success === false && resp.hasOwnProperty("message")) {
                var msg = resp.hasOwnProperty("msg") ? resp.msg : resp.message;
                Utils.showMessage('Ошибка', 'Что то пошло не так :(', 450, Ext.Msg.OK, Ext.Msg.ERROR, true);
            }
        });

        Ext.Ajax.on('requestexception', function (conn, response, options) {
            Utils.showMessage('Ошибка', 'Что то пошло не так :(', 450, Ext.Msg.OK, Ext.Msg.ERROR, true);
        });
    }
});
