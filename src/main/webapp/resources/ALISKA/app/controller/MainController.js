Ext.define('ALISKA.controller.MainController', {
    extend: 'Ext.app.Controller',
    views: ['MainPanel'],
    //stores: ['MainStore'],
    //models: ['MainModel'],
    init: function() {
        this.control({
            'mainpanel': {
                fileupload: this.uploadFileAction
            }
        });
       //this.refreshStore();
    },
    uploadFileAction: function (fb) {
        var file = fb.fileInputEl.dom.files[0];
        this.uploadFile(file);
    },
    uploadFile: function(file) {
    }
});