var ajquery = function () {
    Ext.onReady(function(){
        Ext.Ajax.request({
            url: '/loadfile',
            success: function(response, options){
                alert(response.responseText);
            },
            failure: function(response, options){
                alert("Ошибка: " + response.statusText);
            }
        });
    });
};
Ext.define('ALISKA.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.mainpanel',

    title: 'Алиска',
    //store: 'MainStore',

    initComponent: function () {
        this.items = [
            {
                xtype: 'container',
                layout: {
                    type: 'hbox',
                    align: 'stretch'
                },
                margin: '0 0 5 0',
                combineErrors: true,
                defaultType: 'textareafield',
                items: [
                    {
                        xtype: 'filefield',
                        id: 'loadFile',
                        buttonOnly: true,
                        buttonText: 'Загрузить файл .xls',
                        hideLabel: true,
                        name: 'LoadFile',
                        tip: 'Загрузить файл .xls',
                        listeners: {
                            render: function(c) {
                                Ext.create('Ext.tip.ToolTip', {
                                    target: c.getEl(),
                                    html: c.tip,
                                    trackMouse: true
                                });
                            },
                            'change': function(fb){
                                self.fireEvent('fileupload',fb);


                            }
                        }
                    }

                ]}];
        this.callParent(arguments);
    }
    });