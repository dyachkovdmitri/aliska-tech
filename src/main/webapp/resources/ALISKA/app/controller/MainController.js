Ext.define('ALISKA.controller.MainController', {
    extend: 'Ext.app.Controller',
    views: ['MainPanel','GetOfferPanel', 'AddPrice'],
    stores: ['ItemOfferStore'],
    models: ['ItemOfferModel'],
    init: function() {
        this.control({
            'getOfferPanel': {
                fileupload: this.uploadFileAction
            }
        });
    },
    uploadFileAction: function (fb) {
        var self = this;
        var file = fb.fileInputEl.dom.files[0];
        if (!(/\.(xlsx)$/i).test(file.name)) {
            Ext.Msg.alert("Неверный формат!", "Возможна загрузка файлов только формата xlsx");
            return;
        }
        self.uploadFile(file);
        fb.fileInputEl.dom.value = '';
    },

    uploadFile: function(file) {
        var xhr = new XMLHttpRequest();
        // xhr.upload.onprogress = function (event) {
        //     var percent = event.loaded / event.total;
        //     if (event.loaded < event.total) {
        //         Ext.MessageBox.updateProgress(percent, Math.round(percent * 100) + '% обработано');
        //     } else {
        //         Ext.MessageBox.wait("Обработка...", 'Загрузка CSV');
        //     }
        // };

        xhr.onload = xhr.onerror = function () {
            if (this.status == 200) {
                var data = JSON.parse(xhr.responseText);
                console.log(data);
               //  Ext.offerNumber = data.id;
               // Ext.getStore('ItemOfferStore').load();
            //     Ext.MessageBox.show({
            //         title: "Загрузка успешна",
            //         msg: data.msg,
            //         buttons: Ext.MessageBox.OK,
            //         icon: Ext.MessageBox.WARNING
            //     });
            // } else {
            //     Ext.MessageBox.hide();
            //     Ext.MessageBox.show({
            //         title: 'Произошла ошибка',
            //         msg: xhr.statusText + ". Код: " + this.status,
            //         buttons: Ext.MessageBox.OK,
            //         icon: Ext.MessageBox.WARNING,
            //     });
            }
        };

        xhr.open("POST", "customerRequest/loadfile/", true);
        var formData = new FormData();
        formData.append("file", file);
        xhr.send(formData);
    }
});