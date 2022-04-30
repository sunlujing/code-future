#### design parking plot;

question:

car size; spot size, S-Size can be placed in Middle-size;
do we need multiple floor of parking;
do we carcluate the fee?
do we need schduleing strategy;
do we need to design the waiting queue?
do we has muliptle entrance?

most simple case :
produce and consumer;

small spot queue;
larget spor queue;
Map<car, spot> parkingRecord;

can hanle basic cases;

if fee? :
add more infor into parking recording;

if(schedule strategy){
	///need to caclcuate based on current context;
	
	we can design more about the parking;
	
}

#### design elevator

must simplify the schedule to from up-20;then down to 0; 
the strategy is one up-round and then down-round;
two queue to handle the request in the middle to open the door;
