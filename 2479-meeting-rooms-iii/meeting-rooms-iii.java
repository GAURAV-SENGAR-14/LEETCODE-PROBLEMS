class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        int m = meetings.length;
        long[] lastavailable = new long[n];
        int[] roomsused = new int[n];

        for(int[] meet : meetings){
            int start = meet[0], end = meet[1];
            boolean found = false;
            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;
            //find the first available meeting room
            for (int room = 0; room < n; room++) {
                if (lastavailable[room] <= start) {
                    found = true;
                    lastavailable[room] = end;
                    roomsused[room]++;
                    break;
                }

                if (lastavailable[room] < earlyEndRoomTime) {
                    earlyEndRoom = room;
                    earlyEndRoomTime = lastavailable[room];
                }
            }

            if (!found) {
                lastavailable[earlyEndRoom] += (end - start);
                roomsused[earlyEndRoom]++;
            }
        }
        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomsused[room] > maxUse) {
                maxUse = roomsused[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}