Ext.define('HomeBills.view.CategoryList', {
    extend: 'Ext.view.View',
    store: 'CategoryStore',
    xtype : 'categorylist',
    cls : 'category-list',
    autoEl : 'ul',
    tpl: new Ext.XTemplate(
        '<tpl for=".">',
        '   <li class="category-list-item">{name}</li>',
        '</tpl>'
    ),
    itemSelector: 'li.category-list-item',
    selectionModel : {
        mode : 'SINGLE',
        allowDeselect : false,
        deselectOnContainerClick : false
    }
})
