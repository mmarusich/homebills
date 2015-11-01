Ext.define('HomeBills.view.ProductWindowView', {
    extend : 'Ext.window.Window',
    xtype : 'productwindow',
    title: 'Добаление Продукта',
    constrain: true,
    modal: true,
    width: 300,
    bodyPadding: 20,
    layout: {
        type: 'vbox',
        align: 'stretch',
        pack: 'start'
    },
    fbar: [
        '->',
        {
            xtype: 'button',
            action : 'addProduct',
            text: 'Добавить'
        }
    ],
    items: [
        {
            xtype: 'textfield',
            fieldLabel: 'Имя',
            labelAlign: 'top',
            allowBlank: false,
            name : 'name'
        }
    ]

})
