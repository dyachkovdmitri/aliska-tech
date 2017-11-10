Ext.define('ALISKA.store.PriceStore', {
        extend: 'Ext.data.Store',
        model: "ALISKA.model.PriceModel",
        autoLoad: true,
        storeId: 'PriceStore',
        proxy: {
            type: 'ajax',
            url: 'price/getAvailable',
            reader: {
                type: 'json',
                root: 'data',
                successProperty: 'status'
            }
        }
    }
);