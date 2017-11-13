
Ext.define('ALISKA.controller.MainController', {
    extend: 'Ext.app.Controller',
    views: ['MainPanel', 'GetOfferPanel', 'AddPrice'],
    stores: ['ItemOfferStore', 'ItemPriceStore'],
    models: ['ItemOfferModel', 'ItemPriceModel'],
    controllers: ['ItemOfferController', 'ItemPriceController'],
    init: function () {

    }

});