Sat_Result
Version
CURRENT

Language
cURL
Documentation
Sat_Result
Sat_result apis

﻿++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

POST insert
http://localhost:8080/sat-result/insert
﻿

Body raw (json)
json
{
    "name":"jack",
    "address":"home 1",
    "city":"nashik",
    "country":"india",
    "pincode":"422004",
    "satScore":"29"
}

GET viewAll
http://localhost:8080/sat-result/view-all

GET getRank
http://localhost:8080/sat-result/get-rank/jack
﻿

PUT update_score
http://localhost:8080/sat-result/update-score/jack?newScore=399


DELETE delete_result
http://localhost:8080/sat-result/delete/jack
﻿


