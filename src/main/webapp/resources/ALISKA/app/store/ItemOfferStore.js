Ext.define('ALISKA.store.ItemOfferStore', {
        extend: 'Ext.data.Store',
        model: "ALISKA.model.ItemOfferModel",
        autoLoad: true,
        storeId: 'ItemOfferStore',
        //data: data,
        proxy: {
            type: 'ajax',
            url: 'customerRequest/getOffer',
            reader: {
                type: 'json',
                root: 'data',
                successProperty: 'status'
            }
        }
    }
);