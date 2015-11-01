Ext.define('HomeBills.view.BillWindowView', {
    extend: 'Ext.window.Window',
    xtype: 'billwindow',
    title: 'Добавление Товара',
    constrain: true,
    modal: true,
    width: 350,
    bodyPadding: 20,
    fbar: [
        '->',
        {
            xtype: 'button',
            action: 'saveBill',
            text: 'Добавить'
        }
    ],
    items: [
        {
            xtype: 'container',
            layout: {
                type: 'hbox',
                align: 'bottom'
            },
            items: [
                {
                    xtype: 'combo',
                    itemId: 'productCombo',
                    fieldLabel: 'Продукт',
                    labelAlign: 'top',
                    store: 'ProductStore',
                    displayField: 'name',
                    valueField: 'id',
                    emptyText: 'Виберите продукт',
                    minChars: 1,
                    validator: function () {
                        if (this.getValue() == null) {
                            return 'Это поле обязательно для заполнения'
                        }
                        return true;
                    },
                    forceSelection: true

                },
                {
                    xtype: 'button',
                    text: 'Добавить',
                    margin: '0 10',
                    action: 'addProduct'
                }
            ]
        },
        {
            xtype: 'numberfield',
            anchor: '100%',
            name: 'price',
            labelAlign: 'top',
            fieldLabel: 'Цена',
            value: 0.1,
            minValue: 0.1,
            margin: '10 0 0 0'
        },
        {
            xtype: 'datefield',
            fieldLabel: 'Дата покупки',
            labelAlign: 'top',
            value: new Date(),
            margin: '10 0 0 0',
            name: 'billDate',
            submitFormat : 'Y-m-d H:i'
        }

    ],
    getValue: function () {
        var me = this,
            value = {};
        value.productId = me.down('combo[itemId=productCombo]').getValue();
        value.cost = me.down('numberfield[name=price]').getValue();
        value.createDate = me.down('datefield[name=billDate]').getValue().getTime();
        return value;
    },
    isValid: function () {
        var me = this;
        return me.down('combo[itemId=productCombo]').isValid()
            && me.down('numberfield[name=price]').isValid()
            && me.down('datefield[name=billDate]').isValid();
    }
})
