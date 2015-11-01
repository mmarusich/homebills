Ext.define('HomeBills.view.login.LoginForm', {
    extend: 'Ext.form.Panel',
    layout: {
        type: 'vbox',
        pack: 'start'
    },
    cls: 'login-form',
    bodyPadding: 20,
    border : 0,
    constructor: function (options) {
        this.onSubmit = options.onSubmit;
        this.callParent(arguments);
    },
    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            url: 'j_spring_security_check',
            title: 'Авторизация',
            items: [
                {
                    xtype: 'textfield',
                    name: 'j_username',
                    enableKeyEvents: true,
                    width : 314,
                    cls: 'login_form_input',
                    emptyText: 'Логин',
                    allowBlank: false,
                    minLength: 4,
                    listeners: {
                        afterrender: function (el) {
                            el.focus();
                        },
                        keyup: function (elem, event) {
                            if (event.getKey() != event.ENTER) {
                                if (!this.up('form').getForm().hasInvalidField()) {
                                    Ext.getCmp('login-btn').enable();
                                } else {
                                    Ext.getCmp('login-btn').disable();
                                }
                            } else {
                                if (!this.up('form').getForm().hasInvalidField()) {
                                    me.onSubmit(this.up('form').getForm());
                                }
                            }
                        }
                    }
                },
                {
                    xtype: 'textfield',
                    name: 'j_password',
                    labelAlign: 'top',
                    margin : '15 0 0 0',
                    cls: 'login_form_input',
                    enableKeyEvents: true,
                    emptyText: 'Пароль',
                    inputType: 'password',
                    allowBlank: false,
                    minLength: 4,
                    width : 314,
                    listeners: {
                        keyup: function (elem, event) {
                            if (event.getKey() != event.ENTER) {
                                if (!this.up('form').getForm().hasInvalidField()) {
                                    this.up('form').getForm().isValid();
                                    Ext.getCmp('login-btn').enable();
                                } else {
                                    Ext.getCmp('login-btn').disable();
                                }
                            } else {
                                if (!this.up('form').getForm().hasInvalidField()) {
                                    me.onSubmit(this.up('form').getForm());
                                }
                            }
                        }
                    }
                },
                {
                    xtype : 'container',
                    width : 314,
                    margin : '20 0 0 0',
                    layout: {
                        type: 'hbox',
                        pack: 'start',
                        align: 'stretch'
                    },
                    items : [
                        {
                            xtype : 'container',
                            id : 'login-form-error-label',
                            html : 'Неправильный логин или пароль',
                            hidden : true,
                            style : {
                                color : '#cf4c35',
                                lineHeight : '30px'
                            }

                        },
                        {
                            xtype : 'tbspacer',
                            flex : 1
                        },
                        {
                            xtype: 'button',
                            text: 'Войти',
                            width : 80,
                            height : 30,
                            id: "login-btn",
                            handler: function () {
                                me.onSubmit(this.up('form').getForm());
                            }
                        }
                    ]
                }
            ]
        });
        me.callParent(arguments);
    }
});

Ext.onReady(function () {
    Ext.create('Ext.container.Container', {
        layout: 'fit',
        cls: 'login-form-wrapper',
        width: 370,
        height: 248,
        padding : 8,
        renderTo: Ext.getBody(),
        items: [
            Ext.create('HomeBills.view.login.LoginForm', {
                onSubmit: function (form) {
                    if (form.isValid()) {
                        Ext.getCmp('login-btn').disable();
                        Ext.get('login-form-error-label').setVisible(false);
                        form.submit({
                            url: 'j_spring_security_check',
                            method: 'POST',
                            success: function (form, action) {
                                var obj = Ext.JSON.decode(action.response.responseText);
                                if (obj.success === true && obj.targetUrl) {
                                    document.location = obj.targetUrl;
                                }
                                Ext.getCmp('login-btn').enable();
                            },
                            failure: function (form, action) {
                                Ext.get('login-form-error-label').setVisible(true);
                                Ext.getCmp('login-btn').enable();
                            }
                        });
                    }
                }
            })
        ]
    })
})