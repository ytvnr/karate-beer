# Enable MongoDB auth

docker exec -it <mongoContainer> /bin/bash

run `mongo` to enter db

then

`use admin
db.createUser({user:"springboot", pwd:"spring", roles:[{role:"dbOwner",db:"Beers"}]})
`

