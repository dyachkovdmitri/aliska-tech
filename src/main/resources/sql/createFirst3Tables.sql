CREATE TABLE CustomerRequest (
    id bigint,
    dateRequest bigint,
    name varchar(255),
    commentary varchar(255)
);

CREATE TABLE requestLine (
    id bigint,
    requestId bigint,
    unparsedLine text,
    parsedLine text,
    assortmentId bigint
);

CREATE TABLE item (
    id bigint,
    unparsedLine text,
    type1 smallint,
    type2 smallint,
    type3 smallint,
    type4 smallint,
    type5 smallint,
    wattage smallint,
    bulbType SMALLINT,
    bulbColor smallInt,
    brand SMALLINT,
    seller SMALLINT,
    voltage smallInt,
    connectorType smallInt,

);

CREATE TABLE bulbType (
    id SMALLINT,
    sinonymes text
);

CREATE TABLE bulbColor (
    id SMALLINT,
    sinonymes text
);

CREATE TABLE connectorType (
    id SMALLINT,
    sinonymes text
);




