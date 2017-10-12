Ext.define('ALISKA.store.MainStore', {
    extend: 'Ext.data.Store',
    model: 'ALISKA.model.MainModel',
    autoLoad: true,
    storeId: 'MainStore',
    proxy: {
        type: 'ajax',
        url: 'app/data/offer.json',
        reader: {
            type: 'json',
            root: 'offer',
            successProperty: 'success'
        }
    }
});