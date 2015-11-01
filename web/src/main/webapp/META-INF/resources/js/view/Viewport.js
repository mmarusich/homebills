Ext.define("HomeBills.view.Viewport", {
    extend: "Ext.container.Viewport",
    layout: {
        type: 'hbox',
        align: 'stretch',
        pack: 'start'
    },
    initComponent: function () {
        var me = this;
        Ext.apply(me, {
            items: [
                {
                    xtype : 'panel',
                    title : 'Категории',
                    width : 300,
                    layout : 'fit',
                    tools : [
                        {
                            xtype : 'button',
                            text : 'Добавить',
                            action : 'addCategory'
                        }
                    ],
                    items : [
                        {
                            xtype : 'categorylist'
                        }
                    ]
                },
                {
                    xtype : 'container',
                    flex : 1,
                    layout : {
                        type: 'vbox',
                        align: 'stretch',
                        pack: 'start'
                    },
                    items : [
                        {
                            xtype : 'container',
                            padding : '0 20',
                            height : 100,
                            layout : {
                                type: 'hbox',
                                align: 'middle',
                                pack: 'start'
                            },
                            items : [
                                {
                                    xtype: 'datefield',
                                    fieldLabel: 'От',
                                    labelAlign : 'top',
                                    value : new Date(new Date().getFullYear(), new Date().getMonth(), 1),
                                    margin : '0 15 0 0'
                                },
                                {
                                    xtype: 'datefield',
                                    fieldLabel: 'До',
                                    labelAlign : 'top',
                                    value : new Date(new Date().getFullYear(), new Date().getMonth() + 1, 0),
                                    margin : '0 20 0 0'
                                },
                                {
                                    xtype : 'button',
                                    text : 'Поиск',
                                    cls : 'bills-search-button'
                                }
                            ]
                        },
                        {
                            xtype : 'billsgrid',
                            flex : 1
                        }
                    ]
                }

            ]
        });
        me.callParent(arguments);
    }
});
