Ext.define('User', {
    extend: 'Ext.data.Model',

    idProperty: 'userID',

    fields: [{
        name: 'userID',
        type: 'int'
    }, {
        name: 'name',
        type: 'string'
    }, {
        name: 'surname',
        type: 'string'
    }, {
        name: 'date',
        type: 'date'
    }, {
        name: 'email',
        type: 'string'
    }, {
        name: 'married',
        type: 'bool'
    }]
});