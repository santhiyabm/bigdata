amazon = load '/home/cloudera/workspace/bigproject/amazon/amaz-lap' USING PigStorage(',') as (id:chararray,name:chararray,core:chararray,ram:chararray,color:chararray,price:long,rating:float,review:chararray);

laptop = FOREACH amazon generate name;

store laptop into '/home/cloudera/workspace/bigproject/output';
