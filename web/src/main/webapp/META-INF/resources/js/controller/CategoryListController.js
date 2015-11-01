Ext.define('HomeBills.controller.CategoryListController', {
    extend: 'Ext.app.Controller',
    views: ['CategoryList'],
    stores: ['CategoryStore'],
    refs : [
        {
            ref : 'categoryList',
            selector : 'categorylist'
        }
    ],
    init: function () {
        var me = this;
        me.listen({
            component : {
                'button[action=addCategory]' : {
                    click : me.onAddButtonClick
                }
            },
            store: {
                '#CategoryStore' : {
                    load : me.onCategoryLoad
                }
            }
        });
        me.callParent(arguments);
    },
    onCategoryLoad : function(store, records){
        var me = this,
            list = me.getCategoryList();
        list.getSelectionModel().select(store.first());
    },
    onAddButtonClick : function(){
        var me = this,
            list = me.getCategoryList(),
            store = list.store;
        Ext.create('Ext.window.Window', {
            title : 'Создать Категорию',
            constrain : true,
            modal : true,
            width : 300,
            layout: {
                type: 'vbox',
                align : 'stretch'
            },
            bodyPadding : 20,
            items : [
                {
                    xtype : 'textfield',
                    fieldLabel : 'Имя',
                    labelAlign : 'top',
                    labelSeparator : '',
                    name : 'name',
                    allowBlank : false,
                    validator : function(value){
                        var record = store.findRecord('name', value, 0, false, false, true);
                        if(record != null){
                            return "Категория с таким именем уже существует"
                        }
                        return true;

                    }
                }
            ],
            fbar : [
                {
                    xtype : 'button',
                    text : 'Создать',
                    handler : function(button){
                        var window = button.up('window'),
                            field = window.down('textfield[name=name]');
                        if(field.isValid()){
                            window.el.mask('Создание...');
                            var model = Ext.create('HomeBills.model.CategoryModel', {
                                name : field.getValue()
                            });
                            model.save({
                                callback : function(records, operation, success){
                                    window.el.unmask();
                                    if(success) {
                                        store.add(records);
                                        list.select(records);
                                        window.close();
                                    }
                                }
                            });
                        }
                    }
                }
            ]

        }).show();
    }
})
