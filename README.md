# Snow Alert
App to inform and notify on snow fall in resorts.

## Feature Backlog (Priority order)
| Feature                                                            | Status |
|--------------------------------------------------------------------|:------:|
| Retrieve all supported destinations                                |        |
| Weather conditions at supported destinations                       |        |
| Piste information at supported destinations                        |        |
| User account                                                       |        |
| Add one of supported destinations to user favourites               |        |
| Remove one of supported destinations to user favourites            |        |
| View in browser                                                    |        |
| View in android app                                                |        |
| Notification when snow starts to fall                              |        |

/country
	LINK: /country/{countryId}

/country/{countryId}
	LINK: /region/{regionId}

/region/{resortId}
	LINK:  /resort/{resortId}

/resort/{resortId}
	LINK: /conditions/{resortId}
	LINK: /piste/{resortId}