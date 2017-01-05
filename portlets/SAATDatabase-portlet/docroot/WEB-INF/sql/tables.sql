create table saat_Dictionary (
	dictionaryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	isroot BOOLEAN,
	iscode BOOLEAN,
	synonym VARCHAR(75) null,
	pattern VARCHAR(75) null,
	beforSynonym LONG,
	afterSynonym LONG,
	foreword BOOLEAN,
	ending BOOLEAN,
	sentence BOOLEAN,
	occure BOOLEAN,
	nagation BOOLEAN,
	priority_mode BOOLEAN,
	codeType VARCHAR(75) null,
	codeValue VARCHAR(75) null,
	priority LONG,
	disease_ids VARCHAR(75) null,
	dirty BOOLEAN,
	disease_ids_count LONG
);

create table saat_DictionaryDictionaryLink (
	dictionaryDictionaryLinkId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dictionaryId LONG,
	dictionaryAddictionId LONG
);