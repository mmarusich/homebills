Ext.define('HomeBills.util.Utils',{
    alternateClassName : 'Utils',
    statics : {
        showMessage : function(title, message, width, buttons, type, closable, callback){
            return Ext.Msg.show({
                title: title,
                msg: message,
                width: width,
                buttons: buttons,
                icon: type,
                closable : closable,
                callback : callback || Ext.emptyFn
            });
        }
    }
});
