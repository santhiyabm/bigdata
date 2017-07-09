amazondog = load '/home/cloudera/workspace/bigproject/amazon/amaz-dog'  USING PigStorage(',') as  (id:chararray,adname:chararray,adquantity:chararray,adprice:long,adrating:float,adreview:chararray);
store amazondog into '/output';
