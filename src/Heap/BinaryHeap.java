package Heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Linzhang
 * @Description TODO    二叉堆的实现（优先级是元素值） 大顶堆
 * @Date 10:58 2019/6/11
 * @Version 1.0
 */
public class BinaryHeap<T extends Comparable<T>> {
    //堆的初始化
    private List<T> mHeap;

    public BinaryHeap() {
        mHeap = new ArrayList<>();
        //这里直接将数组下标为0的元素占用
        //那么在完全二叉树中，如果节点值为n,那么左节点值为2n,右节点值为2n+1
        mHeap.add(0,null);
    }

    //定义一个比较函数，如果a>b，则返回值大于0，反之小于0
    public int compare(T a,T b){
        return a.compareTo(b);
    }

    public void insert(T value){
        //将新插入的放入数组最后
        mHeap.add(value);
        //获取最后一个元素的位置
        int index = mHeap.size() -1;
        //获取父节点的索引
        int parent = index / 2;

        while (index > 1){
            //如果插入值，小于其父节点，就无需调整了
            if (compare(value,mHeap.get(parent)) <=0){
                break;
            }else{
                //插入值大于父节点，则将index节点值设为其父节点值
                mHeap.set(index,mHeap.get(parent));
                index = parent;
                parent = index / 2;
            }
        }
        mHeap.set(index,value);
    }

    public boolean delete(T value){
        if (mHeap.isEmpty()){
            return false;
        }

        //获取元素索引下标
        int index = mHeap.indexOf(value);
        if (index == -1){
            return false;
        }

        //获取最后一个元素的索引
        int lastindex = mHeap.size()-1;

        //获取最后一个索引的值
        T temp = mHeap.get(lastindex);

        //用最后一个索引的值代替要删除节点的值
        mHeap.set(index,temp);

        //然后需要对刚放入删除节点的值，与其自身的左右节点相比较
        int parent;
        while (index < mHeap.size() -1){
            parent = index;

            //替换删除节点的值比他的左右节点值都大
            if (compare(temp,mHeap.get(parent*2))>0&&compare(temp,mHeap.get(parent
                        *2+1))>0){
                break;
            }
            //比较左右节点的值，谁大，就指向谁
            if (compare(mHeap.get(parent*2),mHeap.get(parent*2+1))>0){
                //左节点比右节点大
                index = parent*2;
            }else{
                index = parent*2 +1;
            }
        }

        mHeap.set(index,temp);
        mHeap.remove(lastindex);
        return true;
    }

    //打印二叉堆
    public void printHeap(){
        StringBuilder sb = new StringBuilder();
        for (int i = 1;i< mHeap.size();i++){
            sb.append(mHeap.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }


    //测试
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();

        binaryHeap.insert(1);
        binaryHeap.insert(5);
        binaryHeap.insert(6);
        binaryHeap.insert(8);
        binaryHeap.insert(11);
        binaryHeap.insert(25);

        binaryHeap.printHeap();
    }
}
