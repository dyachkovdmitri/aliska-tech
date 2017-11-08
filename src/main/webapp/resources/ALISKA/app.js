Ext.application({
    name: 'ALISKA',
    requires: ['Ext.container.Viewport','Ext.grid.plugin.RowEditing'],
    appFolder: 'resources/ALISKA/app',
    //title: 'Алиска',
    controllers:['MainController'],
    launch: function () {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'mainpanel'

                }
            ]
        })
    }
});
