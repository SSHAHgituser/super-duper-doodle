//Find which season that has the biggest temperature amplitude. Input par is the int array with temperatures:

int T[]= {-1,-10,10,5,30,15,20,-10,30,10,29,20}
//which means:
//winter: -1,-10,10 spring: 5,30,15 summer: 20,-10,30 autumn: 10,29,20
//temp is always an int,
//int[] T - T.length%4 is equal to 0 (same number of temperatures for every season, could be 2, 3 etc.)
{

    public String solution(int[] T){
    int length = T.length;
    int count = length/4;
    int i=0,j=0,indx=0;
    String name="";
    int maxAmpl;

    int[] winter = new int[count];
    int[] spring = new int[count];
    int[] summer = new int[count];
    int[] autumn = new int[count];
    int[] diff = new int[4];

    for(j=0,i=0;j<count; j++,i++){
        winter[i] = T[j];
    }

    for(j=count,i=0;j<count*2; j++,i++){
        spring[i] = T[j];
    }

    for(j=count*2,i=0;j<count*3; j++,i++){
        summer[i] = T[j];
    }

    for(j=count*3,i=0;j<count*4; j++,i++){
        autumn[i] = T[j];
    }

    Arrays.sort(winter);
    Arrays.sort(spring);
    Arrays.sort(summer);
    Arrays.sort(autumn);

    diff[0] = winter[count-1]-winter[0];
    diff[1] = spring[count-1]-spring[0];
    diff[2] = summer[count-1]-summer[0];
    diff[3] = autumn[count-1]-autumn[0];

    maxAmpl=diff[0];

    for(int k=1; k<4; k++){
        if (diff[k]>maxAmpl){
            maxAmpl = diff[k];
            indx = k;
        }
    }

    switch(indx){
        case 0:
            name = "WINTER";
            break;
        case 1:
            name = "SPRING";
            break;
        case 2:
            name = "SUMMER";
            break;
        case 3:
            name = "AUTUMN";
            break;
    }
    return name;
}
