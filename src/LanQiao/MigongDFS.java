package LanQiao;

import java.util.*;

/**
 * dfs迷宫问题
 */
public class MigongDFS {
    static int p,q;
    static int sx,sy,gx,gy;
    static char[][] map;
    static List<Integer> list=new ArrayList<>();
    static int[][] visited; //已走过的标记
    static List<String> path=new ArrayList<>();
    static int min=99999;
    static int[] dx={1,0,-1,0};//定义四个方向，x向右+1，向左-1,向上，向下都是0；
    static int[] dy={0,1,0,-1};
    static void dfs(int x,int y,int steps) {
        if (x == gx && y == gy) {
            if (steps < min) {
                min = steps;
            }
            System.out.println(steps);
            System.out.println(path);
        return;
        }
        //向四个方向走
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < p&& ny <q&&nx>=0&&ny>=0&&map[nx][ny] != '#' && visited[nx][ny] == 0) {
                path.add("("+String.valueOf(nx)+","+String.valueOf(ny)+")");
                visited[nx][ny] = 1;
                dfs(nx, ny, steps + 1);
                path.remove(path.size()-1);
                visited[nx][ny] = 0;
            }
        }

    return;
    }
    public static void dfs_Stack(int sx,int sy,int ex,int ey){
        visited[sx][sy]=1;
        int steps=0;
        Stack<Node> stack=new Stack<>();
        stack.push(new Node(sx,sy));
        while(!stack.isEmpty()){
            Node temp=stack.peek();
            int j=0;
            for (int i = 0; i < 4; i++) {
                int nx = temp.getX()+dx[i];
                int ny = temp.getY()+dy[i];
                if (nx == ex && ny == ey) {
                    System.out.println(steps+1);
                    return;
                }
                if (nx < p&& ny <q&&nx>=0&&ny>=0&&visited[nx][ny] == 0&& map[nx][ny] != '#' ) {
                    visited[nx][ny] = 1;
                    stack.push(new Node(nx, ny));
                    steps++;
                    break;
                }
                j++;
            }
            if(j==4){
                stack.pop();
                steps--;
                Node temp2=stack.peek();
                visited[temp2.getX()][temp2.getY()]=0;
            }
        }
    }
    public static void bfs(int sx,int sy,int ex,int ey){
        int max=Integer.MAX_VALUE;
        int[][] distance=new int[p][q];
        Queue<Node> queue=new LinkedList<>();
        Node node=new Node(sx,sy);
        queue.offer(node);
        while(!queue.isEmpty()){
            Node n=queue.poll();
            if(n.getX()==ex&&n.getY()==ey){
                list.add(distance[n.getX()][n.getY()]);

            }
            for (int i = 0; i <4 ; i++) {
                int nx=n.getX()+dx[i];
                int ny=n.getY()+dy[i];
                if(nx>p-1||ny>q-1||nx<0||ny<0){
                    continue;
                }
                if(map[nx][ny]!='#'&&visited[nx][ny]==0){
                    visited[nx][ny]=1;
                    distance[nx][ny]=distance[n.getX()][n.getY()]+1;
                    queue.offer(new Node(nx,ny));
                }
            }

        }
        for (Integer dis : list) {
            System.out.println(dis);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//测试数据组数
        while (n--> 0) {
            p = sc.nextInt();//map数组长
            q = sc.nextInt();//map数组宽
            map = new char[p][q];//生成map
            visited=new int[p][q];
            for (int i = 0; i < p; i++) {
                String b = sc.next();
                for (int j = 0; j < q; j++) {
                    map[i][j] = b.charAt(j);
                    if (map[i][j] == 'S') {
                        sx = i;
                        sy = j;
                    }
                    if (map[i][j] == 'E') {
                        gx = i;
                        gy = j;
                    }
                }
            }
            for (int i = 0; i <map.length ; i++) {
                for (int j = 0; j <map[i].length ; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
//            dfs(sx, sy,0);
//            System.out.println(min);
            System.out.println("-----------------------------");
            dfs(sx,sy,0);


        }
    }
}
class Node{
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public Node setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Node setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
