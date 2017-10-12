Ext.application({
    name: 'ALISKA',
    requires: ['Ext.container.Viewport'],
    appFolder: 'resources/ALISKA/app',
    title: 'Алиска',
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
