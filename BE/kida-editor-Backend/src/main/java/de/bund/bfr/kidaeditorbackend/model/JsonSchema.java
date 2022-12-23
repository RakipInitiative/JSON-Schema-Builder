package de.bund.bfr.kidaeditorbackend.model;

public class JsonSchema {

    public static final String schema = "{\n" +
            "  \"$schema\": \"https://json-schema.org/draft/2020-12/schema\",\n" +
            "  \"description\": \"Json Schema for Generic Metadata Schema (GenericModel) Version 1.0\",\n" +
            "  \"title\": \"Generic Model\",\n" +
            "  \"$id\": \"https://www.bfr.bund.de/generic_model.schema.json\",\n" +
            "  \"$defs\": {\n" +
            "    \"contact\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"required\": [\"email\"],\n" +
            "      \"description\": \"Object defined according to vCard standard 4.0\",\n" +
            "      \"properties\": {\n" +
            "        \"title\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Title\",\n" +
            "          \"description\": \"Specifies the job title, functional position or function of the individual associated.\"\n" +
            "        },\n" +
            "        \"familyName\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Family name\",\n" +
            "          \"description\": \"Family name or surname.\"\n" +
            "        },\n" +
            "        \"givenName\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Given name\",\n" +
            "          \"description\": \"Given name\"\n" +
            "        },\n" +
            "        \"email\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"email\",\n" +
            "          \"title\": \"Email\",\n" +
            "          \"description\": \"The address for electronic mail communication.\"\n" +
            "        },\n" +
            "        \"telephone\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Telephone\",\n" +
            "          \"description\": \"The canonical number string for a telephone number for telephony communication.\"\n" +
            "        },\n" +
            "        \"streetAddress\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Address\",\n" +
            "          \"description\": \"Physical delivery address\"\n" +
            "        },\n" +
            "        \"country\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Country\",\n" +
            "          \"description\": \"Full name of the country in English\"\n" +
            "        },\n" +
            "        \"zipCode\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Zip code\",\n" +
            "          \"description\": \"Postal code\"\n" +
            "        },\n" +
            "        \"region\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Region\",\n" +
            "          \"description\": \"State or province\"\n" +
            "        },\n" +
            "        \"timeZone\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Timezone\",\n" +
            "          \"description\": \"Time zone\"\n" +
            "        },\n" +
            "        \"gender\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Gender\",\n" +
            "          \"description\": \"Sex and gender identity. M (male), F (female), O (other), N (none or not applicable) and U (unknown)\"\n" +
            "        },\n" +
            "        \"note\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Note\",\n" +
            "          \"description\": \"Supplemental information or a comment\"\n" +
            "        },\n" +
            "        \"organization\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Organization\",\n" +
            "          \"description\": \"Organization information\"\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"reference\": {\n" +
            "      \"type\": \"object\",\n" +
            "      \"required\": [\"isReferenceDescription\", \"title\", \"doi\"],\n" +
            "      \"properties\": {\n" +
            "        \"isReferenceDescription\": {\n" +
            "          \"type\": \"boolean\",\n" +
            "          \"title\": \"Is_reference_description?\",\n" +
            "          \"description\": \"Indicates whether this specific publication serves as the reference description for the model. There has to be at least one reference where this field is set to 'True'\"\n" +
            "        },\n" +
            "        \"title\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Title\",\n" +
            "          \"description\": \"Title of publication in which the model or date has been described\"\n" +
            "        },\n" +
            "        \"doi\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Publication DOI\",\n" +
            "          \"description\": \"The DOI related to this publication\"\n" +
            "        },\n" +
            "        \"publicationType\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Publication type\",\n" +
            "          \"description\": \"The type of publication, e.g. Report, Journal article, Book, Online database, ... \",\n" +
            "          \"enum\": [\n" +
            "            \"ABST\",\n" +
            "            \"ADVS\",\n" +
            "            \"AGGR\",\n" +
            "            \"ANCIENT\",\n" +
            "            \"ART\",\n" +
            "            \"BILL\",\n" +
            "            \"BLOG\",\n" +
            "            \"BOOK\",\n" +
            "            \"CASE\",\n" +
            "            \"CHAP\",\n" +
            "            \"CHART\",\n" +
            "            \"CLSWK\",\n" +
            "            \"COMP\",\n" +
            "            \"CONF\",\n" +
            "            \"CPAPER\",\n" +
            "            \"CTLG\",\n" +
            "            \"DATA\",\n" +
            "            \"DBASE\",\n" +
            "            \"DICT\",\n" +
            "            \"EBOOK\",\n" +
            "            \"ECHAP\",\n" +
            "            \"EDBOOK\",\n" +
            "            \"EJOUR\",\n" +
            "            \"ELECT\",\n" +
            "            \"ENCYC\",\n" +
            "            \"EQUA\",\n" +
            "            \"FIGURE\",\n" +
            "            \"GEN\",\n" +
            "            \"GOVDOC\",\n" +
            "            \"GRANT\",\n" +
            "            \"HEAR\",\n" +
            "            \"ICOMM\",\n" +
            "            \"INPR\",\n" +
            "            \"JOUR\",\n" +
            "            \"JFULL\",\n" +
            "            \"LEGAL\",\n" +
            "            \"MANSCPT\",\n" +
            "            \"MAP\",\n" +
            "            \"MGZN\",\n" +
            "            \"MPCT\",\n" +
            "            \"MULTI\",\n" +
            "            \"MUSIC\",\n" +
            "            \"NEW\",\n" +
            "            \"PAMP\",\n" +
            "            \"PAT\",\n" +
            "            \"PCOMM\",\n" +
            "            \"RPRT\",\n" +
            "            \"SER\",\n" +
            "            \"SLIDE\",\n" +
            "            \"SOUND\",\n" +
            "            \"STAND\",\n" +
            "            \"STAT\",\n" +
            "            \"THES\",\n" +
            "            \"UNPB\",\n" +
            "            \"VIDEO\"\n" +
            "          ]\n" +
            "        },\n" +
            "        \"date\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"year_date\",\n" +
            "          \"title\": \"Date\",\n" +
            "          \"description\": \"Temporal information on the publication date\"\n" +
            "        },\n" +
            "        \"pmid\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"PubMed ID\",\n" +
            "          \"description\": \"The PubMed ID related to this publication\"\n" +
            "        },\n" +
            "        \"authorList\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Author list\",\n" +
            "          \"description\": \"Name and surname of the authors who contributed to this publication\"\n" +
            "        },\n" +
            "        \"abstract\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Abstract\",\n" +
            "          \"description\": \"Abstract of the publication in which the model or the data has been described \"\n" +
            "        },\n" +
            "        \"journal\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Journal\",\n" +
            "          \"description\": \"Data on the details of the journal in which the model or date has been described\"\n" +
            "        },\n" +
            "        \"volume\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Volume\",\n" +
            "          \"description\": \"Data on the details of the volume in which the model or date has been described\"\n" +
            "        },\n" +
            "        \"issue\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Issue\",\n" +
            "          \"description\": \"Data on the details of the issue in which the model or date has been described\"\n" +
            "        },\n" +
            "        \"status\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Status\",\n" +
            "          \"description\": \"The status of this publication, e.g. Published, Submitted, etc.\"\n" +
            "        },\n" +
            "        \"website\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"title\": \"Website\",\n" +
            "          \"description\": \"A link to the publication website (different from DOI)\"\n" +
            "        },\n" +
            "        \"comment\": {\n" +
            "          \"type\": \"string\",\n" +
            "          \"format\": \"long-text\",\n" +
            "          \"title\": \"Comment\",\n" +
            "          \"description\": \"Further comments related to the reference description, e.g. which section in there describes the specific model or which figure in there can be reproduced with the visualization script\"\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"type\": \"object\",\n" +
            "  \"properties\": {\n" +
            "    \"genericModel\": {\n" +
            "      \"required\": [\"generalInformation\", \"scope\", \"modelMath\"],\n" +
            "      \"type\": \"object\",\n" +
            "      \"properties\": {\n" +
            "        \"generalInformation\": {\n" +
            "          \"required\": [\n" +
            "            \"name\",\n" +
            "            \"identifier\",\n" +
            "            \"creationDate\",\n" +
            "            \"rights\",\n" +
            "            \"reference\"\n" +
            "          ],\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"name\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Name\",\n" +
            "              \"description\": \"A name given to the model or data\"\n" +
            "            },\n" +
            "            \"source\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Source\",\n" +
            "              \"description\": \"A source from which the model/data is derived\",\n" +
            "              \"externalEnum\": \"source\"\n" +
            "            },\n" +
            "            \"identifier\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Identifier\",\n" +
            "              \"description\": \"An unambiguous ID given to the model or data. This can also be created automatically by a software tool\"\n" +
            "            },\n" +
            "            \"author\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"$ref\": \"#/$defs/contact\"\n" +
            "              },\n" +
            "              \"title\": \"Author list\",\n" +
            "              \"description\": \"Person(s) who generated the model code or generated the data set originally\"\n" +
            "            },\n" +
            "            \"creator\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"minItems\": 1,\n" +
            "              \"items\": {\n" +
            "                \"$ref\": \"#/$defs/contact\"\n" +
            "              },\n" +
            "              \"title\": \"Creator list\",\n" +
            "              \"description\": \"The person(s) that created this FSK file including all metadata\"\n" +
            "            },\n" +
            "            \"creationDate\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"format\": \"date-time\",\n" +
            "              \"title\": \"Creation date\",\n" +
            "              \"description\": \"Creation date/time of the FSK file\"\n" +
            "            },\n" +
            "            \"modificationDate\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"string\",\n" +
            "                \"format\": \"date-time\"\n" +
            "              },\n" +
            "              \"title\": \"Modification date\",\n" +
            "              \"description\": \"Date/time of the last version of the FSK file\"\n" +
            "            },\n" +
            "            \"rights\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Rights\",\n" +
            "              \"description\": \"Rights granted for usage, distribution and modification of this FSK file\",\n" +
            "              \"externalEnum\": \"right\"\n" +
            "            },\n" +
            "            \"availability\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Availability\",\n" +
            "              \"description\": \"Availability of data or model, i.e. if the annotated model code / data is included in this FSK file\",\n" +
            "              \"externalEnum\": \"availability\"\n" +
            "            },\n" +
            "            \"url\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"URL\",\n" +
            "              \"description\": \"Web address referencing the resource location (data for example)\",\n" +
            "              \"format\": \"uri\"\n" +
            "            },\n" +
            "            \"format\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Format\",\n" +
            "              \"description\": \"File extension of the model or data file (including version number of format if applicable)\",\n" +
            "              \"externalEnum\": \"format\"\n" +
            "            },\n" +
            "            \"reference\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"$ref\": \"#/$defs/reference\"\n" +
            "              },\n" +
            "              \"title\": \"Description of reference\"\n" +
            "            },\n" +
            "            \"language\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Language\",\n" +
            "              \"description\": \"A language of the resource (some data or reports can be available in French language for example)\",\n" +
            "              \"externalEnum\": \"language\"\n" +
            "            },\n" +
            "            \"software\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Software\",\n" +
            "              \"description\": \"The program or software language in which the model has been implemented\",\n" +
            "              \"externalEnum\": \"software\"\n" +
            "            },\n" +
            "            \"languageWrittenIn\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Language written in\",\n" +
            "              \"description\": \"Software language used to write the model, e.g. R or MatLab\",\n" +
            "              \"externalEnum\": \"language_written_in\"\n" +
            "            },\n" +
            "            \"modelCategory\": {\n" +
            "              \"required\": [\"modelClass\"],\n" +
            "              \"type\": \"object\",\n" +
            "              \"properties\": {\n" +
            "                \"modelClass\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Model class\",\n" +
            "                  \"description\": \"Type of model according to RAKIP classification\",\n" +
            "                  \"externalEnum\": \"model_class\"\n" +
            "                },\n" +
            "                \"modelSubClass\": {\n" +
            "                  \"type\": \"array\",\n" +
            "                  \"items\": {\n" +
            "                    \"type\": \"string\"\n" +
            "                  },\n" +
            "                  \"title\": \"Subclass\",\n" +
            "                  \"description\": \"Sub-cassification of the model given the Model Class\",\n" +
            "                  \"externalEnum\": \"model_subclass\"\n" +
            "                },\n" +
            "                \"modelClassComment\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"format\": \"long-text\",\n" +
            "                  \"title\": \"Comment\",\n" +
            "                  \"description\": \"Comment with further details on the model class\"\n" +
            "                },\n" +
            "                \"basicProcess\": {\n" +
            "                  \"type\": \"array\",\n" +
            "                  \"items\": {\n" +
            "                    \"type\": \"string\"\n" +
            "                  },\n" +
            "                  \"title\": \"Basic process\",\n" +
            "                  \"description\": \"Defines the impact of the process on the hazard (so far only valid for process models and predictive models)\",\n" +
            "                  \"externalEnum\": \"basic_process\"\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"status\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Status\",\n" +
            "              \"description\": \"The curation status of the model\",\n" +
            "              \"externalEnum\": \"status\"\n" +
            "            },\n" +
            "            \"objective\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"format\": \"long-text\",\n" +
            "              \"title\": \"Objective\",\n" +
            "              \"description\": \"Objective of the model or data\"\n" +
            "            },\n" +
            "            \"description\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"format\": \"long-text\",\n" +
            "              \"title\": \"Description\",\n" +
            "              \"description\": \"General description of the study, data or model\"\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"scope\": {\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"product\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"required\": [\"name\", \"unit\"],\n" +
            "                \"properties\": {\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Name\",\n" +
            "                    \"description\": \"The product, matrix or environment (e.g food product, lab media, soil etc.) for which the model or data applies\",\n" +
            "                    \"externalEnum\": \"product_matrix\"\n" +
            "                  },\n" +
            "                  \"description\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"format\": \"long-text\",\n" +
            "                    \"title\": \"Description\",\n" +
            "                    \"description\": \"Detailed description of the product, matrix or environment for which the model or data applies\"\n" +
            "                  },\n" +
            "                  \"unit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Unit\",\n" +
            "                    \"description\": \"Unit of the product, matrix or environment for which the model or data applies\",\n" +
            "                    \"externalEnum\": \"unit\"\n" +
            "                  },\n" +
            "                  \"method\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"title\": \"Method of production\",\n" +
            "                    \"description\": \"Type of production for the product/ matrix\",\n" +
            "                    \"externalEnum\": \"production_method\"\n" +
            "                  },\n" +
            "                  \"packaging\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"title\": \"Packaging\",\n" +
            "                    \"description\": \"Describe container or wrapper that holds the product/matrix. Common type of packaging (paper or plastic bags, boxes, tinplate or aluminium cans, plastic trays, plastic bottles, glass bottles or jars)\",\n" +
            "                    \"externalEnum\": \"packaging\"\n" +
            "                  },\n" +
            "                  \"treatment\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"title\": \"Treatment\",\n" +
            "                    \"description\": \"Used to characterise a product/matrix based on the treatment or processes applied to the product or any indexed ingredient\",\n" +
            "                    \"externalEnum\": \"product_treatment\"\n" +
            "                  },\n" +
            "                  \"originCountry\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Country of origin\",\n" +
            "                    \"description\": \"Country of origin of the food/product (ISO 3166-1-alpha-2 country code)\",\n" +
            "                    \"externalEnum\": \"country\"\n" +
            "                  },\n" +
            "                  \"originArea\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Area of origin\",\n" +
            "                    \"description\": \"Area of origin of the food/product (Nomenclature of territorial units for statistics – NUTS – coding system valid only for EEA and Switzerland).\",\n" +
            "                    \"externalEnum\": \"region\"\n" +
            "                  },\n" +
            "                  \"fisheriesArea\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Fisheries area\",\n" +
            "                    \"description\": \"Fisheries or aquaculture area specifying the origin of the sample (FAO Fisheries areas).\",\n" +
            "                    \"externalEnum\": \"fish_area\"\n" +
            "                  },\n" +
            "                  \"productionDate\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"format\": \"date-time\",\n" +
            "                    \"title\": \"Production date\",\n" +
            "                    \"description\": \"Date of production of food/product\"\n" +
            "                  },\n" +
            "                  \"expiryDate\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"format\": \"date-time\",\n" +
            "                    \"title\": \"Expiration date\",\n" +
            "                    \"description\": \"Expiry date of food/product\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"hazard\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"required\": [\"name\"],\n" +
            "                \"properties\": {\n" +
            "                  \"type\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Hazard type\",\n" +
            "                    \"description\": \"General classification of the hazard for which the model or data applies\",\n" +
            "                    \"externalEnum\": \"hazard_type\"\n" +
            "                  },\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Hazard name\",\n" +
            "                    \"description\": \"Name of the hazard (agent, contaminant, chemical) for which the data or model applies\",\n" +
            "                    \"externalEnum\": \"hazard\"\n" +
            "                  },\n" +
            "                  \"description\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"format\": \"long-text\",\n" +
            "                    \"title\": \"Description\",\n" +
            "                    \"description\": \"Description of the hazard for which the model or data applies\"\n" +
            "                  },\n" +
            "                  \"unit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Unit\",\n" +
            "                    \"description\": \"Unit of the hazard for which the model or data applies\",\n" +
            "                    \"externalEnum\": \"unit\"\n" +
            "                  },\n" +
            "                  \"adverseEffect\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Adverse effect\",\n" +
            "                    \"description\": \"Adverse effect induced by hazard about morbidity, mortality, and etcetera\"\n" +
            "                  },\n" +
            "                  \"sourceOfContamination\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Source of contamination\",\n" +
            "                    \"description\": \"rigin of the contamination, source\"\n" +
            "                  },\n" +
            "                  \"benchmarkDose\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Benchmark Dose (BMD)\",\n" +
            "                    \"description\": \"A dose or concentration that produces a predetermined change in response rate of an adverse effect (called the benchmark response or BMR) compared to background\"\n" +
            "                  },\n" +
            "                  \"maximumResidueLimit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Maximum Residue Limit (MRL)\",\n" +
            "                    \"description\": \"International regulations and permissible maximum residue levels in food and drinking water\"\n" +
            "                  },\n" +
            "                  \"noObservedAdverseAffectLevel\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"No Observed Adverse Affect Level (NOAEL)\",\n" +
            "                    \"description\": \"Level of exposure of an organism, found by experiment or observation, at which there is no biologically or statistically significant increase in the frequency or severity of any adverse effects in the exposed population when compared to its appropriate control\"\n" +
            "                  },\n" +
            "                  \"lowestObservedAdverseAffectLevel\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Lowest Observed Adverse Effect Level (LOAEL)\",\n" +
            "                    \"description\": \"Lowest concentration or amount of a substance found by experiment or observation that causes an adverse alteration of morphology, function, capacity, growth, development, or lifespan of a target organism distinguished from normal organisms of the same species under defined conditions of exposure\"\n" +
            "                  },\n" +
            "                  \"acceptableOperatorsExposureLevel\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Acceptable Operator Exposure Level (AOEL)\",\n" +
            "                    \"description\": \"Maximum amount of active substance to which the operator may be exposed without any adverse health effects. The AOEL is expressed as milligrams of the chemical per kilogram body weight of the operator\"\n" +
            "                  },\n" +
            "                  \"acuteReferenceDose\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Acute Reference Dose (ARfD)\",\n" +
            "                    \"description\": \"An estimate (with uncertainty spanning perhaps an order of magnitude) of a daily oral exposure for an acute duration (24 hours or less) to the human population (including sensitive subgroups) that is likely to be without an appreciable risk of deleterious effects during a lifetime\"\n" +
            "                  },\n" +
            "                  \"acceptableDailyIntake\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Acceptable Daily Intake (ADI)\",\n" +
            "                    \"description\": \"Measure of amount of a specific substance in food or in drinking water tahta can be ingested (orally) on a daily basis over a lifetime without an appreciable health risk\"\n" +
            "                  },\n" +
            "                  \"indSum\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Individual or Summed Hazard\",\n" +
            "                    \"description\": \"Define if the parameter reported is an individual residue/analyte, a summed residue definition or part of a sum a summed residue definition\",\n" +
            "                    \"externalEnum\": \"ind_sum\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"populationGroup\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"required\": [\"name\"],\n" +
            "                \"properties\": {\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Population name\",\n" +
            "                    \"description\": \"Name of the population for which the model or data applies\"\n" +
            "                  },\n" +
            "                  \"targetPopulation\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Target population\",\n" +
            "                    \"description\": \"Population of individual that we are interested in describing and making statistical inferences about\"\n" +
            "                  },\n" +
            "                  \"populationSpan\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"title\": \"Population span (years)\",\n" +
            "                    \"description\": \"Temporal information on the exposure duration\"\n" +
            "                  },\n" +
            "                  \"populationDescription\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"title\": \"Description\",\n" +
            "                    \"description\": \"Description of the population for which the model applies (demographic and socio-economic characteristics for example). Background information that are needed in the data analysis phase, size of household, education level, employment status, professional category, ethnicity, etc.\"\n" +
            "                  },\n" +
            "                  \"populationAge\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"title\": \"Population age\",\n" +
            "                    \"description\": \"Description of the range of age or group of age\"\n" +
            "                  },\n" +
            "                  \"populationGender\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Population gender\",\n" +
            "                    \"description\": \"Description of the percentage of gender\"\n" +
            "                  },\n" +
            "                  \"bmi\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"BMI\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Description of the range of BMI or class of BMI or BMI mean\"\n" +
            "                  },\n" +
            "                  \"specialDietGroups\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Special diet groups\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Description of sub-population with special diets (vegetarians, diabetics, group following special ethnic diets)\"\n" +
            "                  },\n" +
            "                  \"patternConsumption\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Consumption pattern\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Description of the consumption of different food items, frequency, portion size\"\n" +
            "                  },\n" +
            "                  \"region\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Region\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Spatial information (area) on which the population group of the model or data applies\",\n" +
            "                    \"externalEnum\": \"region\"\n" +
            "                  },\n" +
            "                  \"country\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Country\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Country on which the population group of the model or data applies\",\n" +
            "                    \"externalEnum\": \"country\"\n" +
            "                  },\n" +
            "                  \"populationRiskFactor\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Risk and population factors\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Population risk factor that may influence the outcomes of the study, confounder should be included\"\n" +
            "                  },\n" +
            "                  \"season\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Season\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Distribution of surveyed people according to the season (influence consumption pattern)\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"generalComment\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"format\": \"long-text\",\n" +
            "              \"title\": \"General comment\",\n" +
            "              \"description\": \"General comments on the scope of the study, data or model\"\n" +
            "            },\n" +
            "            \"temporalInformation\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"format\": \"long-text\",\n" +
            "              \"title\": \"Temporal information\",\n" +
            "              \"description\": \"Temporal information on which the model or data applies / An interval of time that is named or defined by its start and end dates (period of study)\"\n" +
            "            },\n" +
            "            \"spatialInformation\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"title\": \"Spatial information\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"string\"\n" +
            "              },\n" +
            "              \"description\": \"Spatial information (area) on which the model or data applies\"\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"dataBackground\": {\n" +
            "          \"required\": [\"study\"],\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"study\": {\n" +
            "              \"required\": [\"title\"],\n" +
            "              \"type\": \"object\",\n" +
            "              \"properties\": {\n" +
            "                \"identifier\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Study identifier\",\n" +
            "                  \"description\": \"A user defined identifier for the study\"\n" +
            "                },\n" +
            "                \"title\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"format\": \"long-text\",\n" +
            "                  \"title\": \"Study title\",\n" +
            "                  \"description\": \"A title for the study\"\n" +
            "                },\n" +
            "                \"description\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"format\": \"long-text\",\n" +
            "                  \"title\": \"Study description\",\n" +
            "                  \"description\": \"A brief description of the study aims\"\n" +
            "                },\n" +
            "                \"designType\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Design type\",\n" +
            "                  \"description\": \"The type of study design being employed\"\n" +
            "                },\n" +
            "                \"assayMeasurementType\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Assay measurement type\",\n" +
            "                  \"description\": \"The measurement being observed in this assay\"\n" +
            "                },\n" +
            "                \"assayTechnologyType\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Assay technology type\",\n" +
            "                  \"description\": \"The technology being employed to observe this measurement\",\n" +
            "                  \"externalEnum\": \"technology_type\"\n" +
            "                },\n" +
            "                \"assayTechnologyPlatform\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Assay technology platform\",\n" +
            "                  \"description\": \"The technology platform used\"\n" +
            "                },\n" +
            "                \"accreditationProcedureForTheAssayTechnology\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Accreditation procedure for assay\",\n" +
            "                  \"description\": \"Accreditation procedure for the analytical method used\",\n" +
            "                  \"externalEnum\": \"accreditation_procedure\"\n" +
            "                },\n" +
            "                \"protocolName\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Protocol name\",\n" +
            "                  \"description\": \"The name of the protocol, e.g.Extraction Protocol\"\n" +
            "                },\n" +
            "                \"protocolType\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Protocol type\",\n" +
            "                  \"description\": \"The type of the protocol, preferably coming from an Ontology, e.g. Extraction Protocol\"\n" +
            "                },\n" +
            "                \"protocolDescription\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"format\": \"long-text\",\n" +
            "                  \"title\": \"Protocol description\",\n" +
            "                  \"description\": \"A description of the protocol\"\n" +
            "                },\n" +
            "                \"protocolURI\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Protocol URI\",\n" +
            "                  \"description\": \"A URI to link out to a publication, web page, etc. describing the protocol\"\n" +
            "                },\n" +
            "                \"protocolVersion\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Protocol version\",\n" +
            "                  \"description\": \"The version of the protocol used, where applicable.\"\n" +
            "                },\n" +
            "                \"protocolParametersName\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Parameters names\",\n" +
            "                  \"description\": \"The parameters used when executing this protocol\"\n" +
            "                },\n" +
            "                \"protocolComponentsName\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Components names\",\n" +
            "                  \"description\": \"The names of the components used when carrying out this protocol\"\n" +
            "                },\n" +
            "                \"protocolComponentsType\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Protocol components type\",\n" +
            "                  \"description\": \"Description\"\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"studySample\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"required\": [\n" +
            "                  \"sampleName\",\n" +
            "                  \"protocolOfSampleCollection\",\n" +
            "                  \"samplingPlan\",\n" +
            "                  \"samplingWeight\",\n" +
            "                  \"samplingSize\"\n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                  \"sampleName\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Name\",\n" +
            "                    \"description\": \"An unambiguous ID given to the samples used in the assay\"\n" +
            "                  },\n" +
            "                  \"protocolOfSampleCollection\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Protocol of sample collection\",\n" +
            "                    \"description\": \"Additional protocol for sample and sample collection. Corresponds to the Protocol REF in ISA\"\n" +
            "                  },\n" +
            "                  \"samplingStrategy\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Sampling strategy\",\n" +
            "                    \"description\": \"Sampling strategy (ref. EUROSTAT - Typology of sampling strategy, version of July 2009)\",\n" +
            "                    \"externalEnum\": \"sampling_strategy\"\n" +
            "                  },\n" +
            "                  \"typeOfSamplingProgram\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Type of sampling program\",\n" +
            "                    \"description\": \"Indicate the type of programm for which the samples have been collected\",\n" +
            "                    \"externalEnum\": \"sampling_program\"\n" +
            "                  },\n" +
            "                  \"samplingMethod\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Sampling method\",\n" +
            "                    \"description\": \"Sampling method used to take the sample\",\n" +
            "                    \"externalEnum\": \"sampling_method\"\n" +
            "                  },\n" +
            "                  \"samplingPlan\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Sampling plan\",\n" +
            "                    \"description\": \"Description of data collection technique: stratified or complex sampling (several stages)\"\n" +
            "                  },\n" +
            "                  \"samplingWeight\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Sampling weight\",\n" +
            "                    \"description\": \"Description of the method employed to compute sampling weight (nonresponse-adjusted weight)\"\n" +
            "                  },\n" +
            "                  \"samplingSize\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Sampling size\",\n" +
            "                    \"description\": \"Number of units, full participants, partial participants, eligibles, not eligible, unresolved (eligibility status not resolved)\"\n" +
            "                  },\n" +
            "                  \"lotSizeUnit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Lot size unit\",\n" +
            "                    \"description\": \"Unit in which the lot size is expressed\"\n" +
            "                  },\n" +
            "                  \"samplingPoint\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Sampling point\",\n" +
            "                    \"description\": \"Point in the food chain where the sample was taken. (Doc. ESTAT/F5/ES/155 “Data dictionary of activities of the establishments”)\",\n" +
            "                    \"externalEnum\": \"sampling_point\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"dietaryAssessmentMethod\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"required\": [\n" +
            "                  \"collectionTool\",\n" +
            "                  \"numberOfNonConsecutiveOneDay\",\n" +
            "                  \"numberOfFoodItems\",\n" +
            "                  \"recordTypes\",\n" +
            "                  \"foodDescriptors\"\n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                  \"collectionTool\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Methodological tool to collect data\",\n" +
            "                    \"description\": \"Food diaries, interview, 24-hour recall interview, food propensy questionnaire, portion size measurement aids, eating outside questionnaire\",\n" +
            "                    \"externalEnum\": \"collection_tool\"\n" +
            "                  },\n" +
            "                  \"numberOfNonConsecutiveOneDay\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Number of non-consecutive one-day\",\n" +
            "                    \"description\": \"Number of non-consecutive one-day recorded\"\n" +
            "                  },\n" +
            "                  \"softwareTool\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Dietary software tool\",\n" +
            "                    \"description\": \"Name of the software used to collect the data\"\n" +
            "                  },\n" +
            "                  \"numberOfFoodItems\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Number of food items\",\n" +
            "                    \"minItems\": 1,\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Number of food items\"\n" +
            "                  },\n" +
            "                  \"recordTypes\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Type of records\",\n" +
            "                    \"minItems\": 1,\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Consumption occasion, mean of consumption, quantified and described as eaten, recipes for self-made\"\n" +
            "                  },\n" +
            "                  \"foodDescriptors\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Food descriptors\",\n" +
            "                    \"minItems\": 1,\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Description using FoodEx2 facet\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"laboratory\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"required\": [\"accreditation\"],\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"accreditation\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Laboratory accreditation\",\n" +
            "                    \"minItems\": 1,\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"The laboratory accreditation to ISO/IEC 17025\",\n" +
            "                    \"externalEnum\": \"laboratory_accreditation\"\n" +
            "                  },\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Laboratory name\",\n" +
            "                    \"description\": \"Laboratory code (National laboratory code if available) or Laboratory name \"\n" +
            "                  },\n" +
            "                  \"country\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Laboratory country\",\n" +
            "                    \"description\": \"Country where the laboratory is placed. (ISO 3166-1-alpha-2)\",\n" +
            "                    \"externalEnum\": \"country\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"assay\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"required\": [\"name\"],\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Assay name\",\n" +
            "                    \"description\": \"A name given to the assay\"\n" +
            "                  },\n" +
            "                  \"description\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"format\": \"long-text\",\n" +
            "                    \"title\": \"Description\",\n" +
            "                    \"description\": \"General description of the assay. Corresponds to the Protocol REF in ISA\"\n" +
            "                  },\n" +
            "                  \"moisturePercentage\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Percentage of moisture\",\n" +
            "                    \"description\": \"Percentage of moisture in the original sample\"\n" +
            "                  },\n" +
            "                  \"fatPercentage\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Percentage of fat\",\n" +
            "                    \"description\": \"Percentage of fat in the original sample\"\n" +
            "                  },\n" +
            "                  \"detectionLimit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Limit of detection\",\n" +
            "                    \"description\": \"Limit of detection reported in the unit specified by the variable Hazard unit\"\n" +
            "                  },\n" +
            "                  \"quantificationLimit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Limit of quantification\",\n" +
            "                    \"description\": \"Limit of quantification reported in the unit specified by the variable Hazard unit\"\n" +
            "                  },\n" +
            "                  \"leftCensoredData\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Left-censored data\",\n" +
            "                    \"description\": \"Percentage of measures equal to LOQ and/or LOD\"\n" +
            "                  },\n" +
            "                  \"contaminationRange\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Range of contamination\",\n" +
            "                    \"description\": \"Range of result of the analytical measure reported in the unit specified by the variable Hazard unit\"\n" +
            "                  },\n" +
            "                  \"uncertaintyValue\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Uncertainty value\",\n" +
            "                    \"description\": \"Indicate the expanded uncertainty (usually 95% confidence interval) value associated with the measurement expressed in the unit reported in the field Hazard unit\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        },\n" +
            "        \"modelMath\": {\n" +
            "          \"required\": [\"parameter\"],\n" +
            "          \"type\": \"object\",\n" +
            "          \"properties\": {\n" +
            "            \"parameter\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"minItems\": 1,\n" +
            "              \"items\": {\n" +
            "                \"required\": [\n" +
            "                  \"id\",\n" +
            "                  \"classification\",\n" +
            "                  \"name\",\n" +
            "                  \"unit\",\n" +
            "                  \"dataType\"\n" +
            "                ],\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"id\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter ID\",\n" +
            "                    \"description\": \"An unambiguous ID given to each of the parameters - preferably autogenerated by a software tool and compatible with SBML ID requirements, only letters from A to Z, numbers and '_'\",\n" +
            "                    \"format\": \"sid\"\n" +
            "                  },\n" +
            "                  \"classification\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter classification\",\n" +
            "                    \"description\": \"General classification of the parameter (e.g. Input, Constant, Output etc)\",\n" +
            "                    \"enum\": [\"CONSTANT\", \"INPUT\", \"OUTPUT\"]\n" +
            "                  },\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter name\",\n" +
            "                    \"description\": \"A name given to the parameter\"\n" +
            "                  },\n" +
            "                  \"description\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Description\",\n" +
            "                    \"description\": \"General description of the parameter\"\n" +
            "                  },\n" +
            "                  \"unit\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Unit\",\n" +
            "                    \"description\": \"Unit of the parameter\",\n" +
            "                    \"externalEnum\": \"unit\"\n" +
            "                  },\n" +
            "                  \"unitCategory\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Unit category\",\n" +
            "                    \"description\": \"General classification of the parameter unit\",\n" +
            "                    \"externalEnum\": \"unit_category\"\n" +
            "                  },\n" +
            "                  \"dataType\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Data type\",\n" +
            "                    \"description\": \"Information on the data format of the parameter, e.g. if it is a categorical variable: int, double, array of size x,y,z \",\n" +
            "                    \"enum\": [\n" +
            "                      \"INTEGER\",\n" +
            "                      \"DOUBLE\",\n" +
            "                      \"NUMBER\",\n" +
            "                      \"DATE\",\n" +
            "                      \"FILE\",\n" +
            "                      \"BOOLEAN\",\n" +
            "                      \"VECTOROFNUMBERS\",\n" +
            "                      \"VECTOROFSTRINGS\",\n" +
            "                      \"MATRIXOFNUMBERS\",\n" +
            "                      \"MATRIXOFSTRINGS\",\n" +
            "                      \"OBJECT\",\n" +
            "                      \"STRING\"\n" +
            "                    ]\n" +
            "                  },\n" +
            "                  \"source\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter source\",\n" +
            "                    \"description\": \"Information on the type of knowledge used to define the parameter value\",\n" +
            "                    \"externalEnum\": \"parameter_source\"\n" +
            "                  },\n" +
            "                  \"subject\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter subject\",\n" +
            "                    \"description\": \"Scope of the parameter, e.g. if it refers to an animal, a batch of animals, a batch of products, a carcass, a carcass skin etc\",\n" +
            "                    \"externalEnum\": \"parameter_subject\"\n" +
            "                  },\n" +
            "                  \"distribution\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter distribution\",\n" +
            "                    \"description\": \"Distribution describing the parameter variabilty. If no distribution selected this means the value provided in 'Parameter value' is a point estimate. In case a distribution is selected the value provided in 'Parameter value' is a string that the model code can parse in order to sample from the named distribution\",\n" +
            "                    \"externalEnum\": \"parameter_distribution\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Value\",\n" +
            "                    \"description\": \"A default value for the parameter. This is mandatory (needs to be provided) for all parameters of type 'Input'\"\n" +
            "                  },\n" +
            "                  \"reference\": {\n" +
            "                    \"$ref\": \"#/$defs/reference\",\n" +
            "                    \"title\": \"Parameter reference\",\n" +
            "                    \"description\": \"Information on the source, where the value of the parameter has been extracted from - if available. The format should use that used in other 'Reference' metadata. Preferably DOI.\"\n" +
            "                  },\n" +
            "                  \"variabilitySubject\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Parameter variability subject\",\n" +
            "                    \"description\": \"Information on which the variability is described. It can be variability between broiler in a flock, variability between all meat packages sold in Denmark, variability between days, etc.\"\n" +
            "                  },\n" +
            "                  \"minValue\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Value min\",\n" +
            "                    \"description\": \"Numerical value of the minimum limit of the parameter that determines the range of applicability for which the model applies\"\n" +
            "                  },\n" +
            "                  \"maxValue\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Value max\",\n" +
            "                    \"description\": \"Numerical value of the maximum limit of the parameter that determines the range of applicability for which the model applies\"\n" +
            "                  },\n" +
            "                  \"error\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Error\",\n" +
            "                    \"description\": \"Error of the parameter value\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"qualityMeasures\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"sse\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"SSE\",\n" +
            "                    \"description\": \"Statistical values calculated to describe the performance of the model fitting procedure\"\n" +
            "                  },\n" +
            "                  \"mse\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"MSE\",\n" +
            "                    \"description\": \"Statistical values calculated to describe the performance of the model fitting procedure\"\n" +
            "                  },\n" +
            "                  \"rmse\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"RMSE\",\n" +
            "                    \"description\": \"Statistical values calculated to describe the performance of the model fitting procedure\"\n" +
            "                  },\n" +
            "                  \"rsquared\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"R squared\",\n" +
            "                    \"description\": \"Statistical values calculated to describe the performance of the model fitting procedure\"\n" +
            "                  },\n" +
            "                  \"aic\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"AIC\",\n" +
            "                    \"description\": \"Statistical values calculated to describe the performance of the model fitting procedure\"\n" +
            "                  },\n" +
            "                  \"bic\": {\n" +
            "                    \"type\": \"number\",\n" +
            "                    \"title\": \"BIC\",\n" +
            "                    \"description\": \"Statistical values calculated to describe the performance of the model fitting procedure\"\n" +
            "                  },\n" +
            "                  \"sensitivityAnalysis\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"format\": \"long-text\",\n" +
            "                    \"title\": \"Sensitivity analysis\",\n" +
            "                    \"description\": \"Description of the results of an sensitivity analysis, i.e. how independence assumptions are met or how variables will affect the output of model\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"modelEquation\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"items\": {\n" +
            "                \"required\": [\"name\", \"modelEquation\"],\n" +
            "                \"type\": \"object\",\n" +
            "                \"properties\": {\n" +
            "                  \"name\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Model equation name\",\n" +
            "                    \"description\": \"A name given to the model equation\"\n" +
            "                  },\n" +
            "                  \"modelEquationClass\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Model equation class\",\n" +
            "                    \"description\": \"Information on that helps to categorize model equations\"\n" +
            "                  },\n" +
            "                  \"reference\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Model equation reference\",\n" +
            "                    \"items\": {\n" +
            "                      \"$ref\": \"#/$defs/reference\"\n" +
            "                    },\n" +
            "                    \"description\": \"Information on the source, where the equation has been extracted from - if available\"\n" +
            "                  },\n" +
            "                  \"modelEquation\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"title\": \"Equation\",\n" +
            "                    \"description\": \"The pointer to the file that holds the software code (e.g. R-script)\"\n" +
            "                  },\n" +
            "                  \"modelHypothesis\": {\n" +
            "                    \"type\": \"array\",\n" +
            "                    \"title\": \"Hypothesis of the model\",\n" +
            "                    \"items\": {\n" +
            "                      \"type\": \"string\"\n" +
            "                    },\n" +
            "                    \"description\": \"Description of the hypothesis of the model\"\n" +
            "                  }\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"fittingProcedure\": {\n" +
            "              \"type\": \"string\",\n" +
            "              \"title\": \"Fitting procedure\",\n" +
            "              \"description\": \"Procedure used to fit the data to the model equation\"\n" +
            "            },\n" +
            "            \"exposure\": {\n" +
            "              \"required\": [\"type\"],\n" +
            "              \"type\": \"object\",\n" +
            "              \"properties\": {\n" +
            "                \"treatment\": {\n" +
            "                  \"type\": \"array\",\n" +
            "                  \"title\": \"Left-censored data treatment\",\n" +
            "                  \"items\": {\n" +
            "                    \"type\": \"string\"\n" +
            "                  },\n" +
            "                  \"description\": \"Description of the mathematical method to replace left-censored data (recommandation of WHO (2013), distribution or others)\"\n" +
            "                },\n" +
            "                \"contamination\": {\n" +
            "                  \"type\": \"array\",\n" +
            "                  \"title\": \"Contam level post data treatment\",\n" +
            "                  \"items\": {\n" +
            "                    \"type\": \"string\"\n" +
            "                  },\n" +
            "                  \"description\": \"Description of the range of of the level of contamination after left censored data treatment\"\n" +
            "                },\n" +
            "                \"type\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Type of exposure\",\n" +
            "                  \"description\": \"Description of the type of exposure\"\n" +
            "                },\n" +
            "                \"scenario\": {\n" +
            "                  \"type\": \"array\",\n" +
            "                  \"title\": \"Scenario\",\n" +
            "                  \"items\": {\n" +
            "                    \"type\": \"string\"\n" +
            "                  },\n" +
            "                  \"description\": \"Description of the different scenarios of exposure assessment\"\n" +
            "                },\n" +
            "                \"uncertaintyEstimation\": {\n" +
            "                  \"type\": \"string\",\n" +
            "                  \"title\": \"Uncertainty estimation\",\n" +
            "                  \"description\": \"Analysis to estimate uncertainty\"\n" +
            "                }\n" +
            "              }\n" +
            "            },\n" +
            "            \"event\": {\n" +
            "              \"type\": \"array\",\n" +
            "              \"title\": \"Event\",\n" +
            "              \"items\": {\n" +
            "                \"type\": \"string\"\n" +
            "              },\n" +
            "              \"description\": \"Definition of time-dependent parameter changes\"\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}\n";
}
