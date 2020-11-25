

//增删改查
db.spit.insert({title:"标题",content:"内容"});
db.spit.find(); 
db.spit.findOne({_id:ObjectId("5fbdb7ef848579272812cb47")});
db.spit.remove({_id:ObjectId("5fbdb7ef848579272812cb47")})
db.spit.update({_id:ObjectId("5fbdb7ef848579272812cb47")},{content:"老弟"} ) //会把其他清空
db.spit.update({_id:ObjectId("5fbdb7ef848579272812cb47")},    //不会把其他清空
    {$set:{content:"你是秀儿"}}
)
db.spit.count()
//统计条数
db.spit.count({_id:"2"})
//模糊查询  使用正则表达式
db.spit.find({title:/好/})
db.spit.find({title:/^好$/}) //以什么开头，以什么结尾


db.spit.count()
//统计条数
db.spit.count({_id:"2"})
//模糊查询  使用正则表达式
db.spit.find({title:/好/})
db.spit.find({title:/^好$/}) //以什么开头，以什么结尾


//条件查询 $gt $lt $gte $lte $ne
db.spit.find({userId:{$gte:"1"}})

//包含   不包含
db.spit.find({userId:{$in:["1","2"]}})
db.spit.find({userId:{$nin:["1","2"]}})

//多条件查询
db.spit.find({$and: [{userId:"1"},{title:{$in:["今天天气特别好"]}}]})
db.spit.find({$or: [{userId:"1"},{userId:"2"}]})


//自增修改
db.spit.update({userId:"1"},{$inc:{visits:NumberInt(1)}})
