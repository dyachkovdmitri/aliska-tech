Ext.speak = function (word) {
    if (word != null) {
        Ext.Ajax.request({
            url: '/customer/addAliskaMonolog',
            params: {
                word: word
            },
            success: function (response, options) {
                Ext.getCmp('aliskaMonolog').setValue(JSON.parse(response.responseText).aliskaMonolog);
            },
            failure: function (response, options) {
                console.log(response);
            }
        });

    } else {
        Ext.Ajax.request({
            url: '/customer/getMe',
            success: function (response, options) {
                Ext.getCmp('aliskaMonolog').setValue(JSON.parse(response.responseText).aliskaMonolog);
            },
            failure: function (response, options) {
                console.log(response);
            }
        });
    }

};
Ext.application({
    name: 'ALISKA',
    requires: ['Ext.container.Viewport', 'Ext.grid.plugin.RowEditing'],
    appFolder: 'resources/ALISKA/app',
    //title: 'Алиска',
    controllers: ['MainController'],
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
