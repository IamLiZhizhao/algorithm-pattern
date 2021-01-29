package com.lizhizhao.algorithm;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lizhizhao
 * @since 2020-08-15 12:15
 */
@SpringBootTest
public class ArrayTest {

    @Test
    private void test(){

    }

    //546. 移除盒子
    public int removeBoxes(int[] boxes) {
        return 0;
    }



    //说明:
    //    1. 作答可以选用JavaScript, C/C++, PHP, JAVA, Python等语言
    //    2. 提交的答案必须可以独立在最基本的编译环境下编译和运行, 不要依赖第3方代码
    //    3. 尽量完成所有的题目, 记录一下各题的大概完成时间
    //    4. 将运行结果截图一起提交
    //
    //1. 请完成下面功能的函数原型设计和实现代码
    //    // BubbleSort() 函数功能定义:
    //    // 对数组元素进行排序, 采用经典冒泡排序（把大的元素往后调）
    //    // 排序比较只涉及整数部分, 例如 4.9 跟 4.2 是相等的
    //    // 如果两个元素相等(整数部分相等), 不能进行交换, 进来保持原来的顺序
    //    // 例如数组: Arr = [2.0, 4.9, 3.2, 4.2, 1.5, 5.0],
    //    // 排序完成后的结果为: [1.5, 2.0, 3.2, 4.9, 4.2, 5.0]
    //    // 返回值为: 交换次数(效率)
    //
    //	// 要求采用简单函数方式(库函数)来实现, 不能使用工具类方式
    //    // 代码效果要求(下面为伪代码实例, 具体形式根据不同语言进行调整):
    //	    Arr = [2.0, 4.9, 3.2, 4.2, 1.5, 5.0];
    //	    Count = BubbleSort(Arr);
    //	    print Count;    // 一共进行了多少次交互
    //	    print Arr; 		// 显示 [1.5, 2.0, 3.2, 4.9, 4.2, 5.0]

    @Test
    public void testBubbleSort() {
        double[] arr = new double[]{2.0, 4.9, 3.2, 4.2, 1.5, 5.0};
        int count = BubbleSort(arr);
        System.out.println(count);  // 一共进行了多少次交互
        for (double v : arr) {
            System.out.println(v); // 显示 [1.5, 2.0, 3.2, 4.9, 4.2, 5.0]
        }
    }

    public int BubbleSort(double[] arr) {
        // 冒泡思想：升序-最小的往前移或最大往后移
        int len = arr.length;
        int times = 0;
        for (int i = 0; i < len; i++) {
            int index = len-1;
            while (index > i) {
                if ((int)arr[index] < (int)arr[index-1]) {
                    swag(arr, index, index-1);
                    times++;
                }
                index--;
            }
        }
        return times;
    }

    private void swag(double[] arr, int i, int j) {
        double tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //
    //2. 编写一个SQL语句,查询那几个班的不合格人数大于5个
    //    班级成绩表结构: ClassID(班别), StudentID(学号), Score(成绩)

    //   假设不合格分数为60以下，不含60，表名是score_p。查询语句如下：
    //   SELECT ClassID,COUNT(StudentID) FROM score_p WHERE Score < 60 GROUP BY ClassID HAVING COUNT(StudentID) > 5;

    //3. 请完成剩下的3个接口的实现伪代码
    //    // 双索引对象(Key/Value模式的数组)
    //    // 按2个或多个KEY可以快速访问某一个对象里面的元素,
    //    // 下面是一个简单的实现(增删改查)
    //    // 伪代码实现即可
    //
    //    $ObjectPool = array("NameIDX"=>array());
    //
    //    function Add($Obj) {
    //        global $ObjectPool;
    //
    //        // 判断参数是否为'空'值或非期望的数组类型
    //        if ($Obj == NULL || gettype($Obj) != "array") {
    //            return false;
    //        }
    //
    //        // 判断参数(对象)里面是否包括必须的3个子项
    //        if ($Obj["ID"] == NULL || $Obj["Name"] == NULL || $Obj["Info"] == NULL) {
    //            return false;
    //        }
    //
    //        $Key = $Obj["ID"];
    //        $Name = $Obj["Name"];
    //
    //        // 判断ID是否重复
    //        if ($ObjectPool[$Key] != NULL) {
    //            return false;
    //        }
    //
    //        // 判断Name是否重复
    //        $NameIDX = $ObjectPool["NameIDX"];
    //        if ($NameIDX[$Name] != NULL) {
    //            return false;
    //        }
    //
    //        // 插入新数据
    //        $ObjectPool[$Key] = $Obj;
    //        $ObjectPool["NameIDX"][$Obj["Name"]] = $Key;
    //
    //        return true;
    //    }
    //
    //    funtion Update($Obj) {
    //        global $ObjectPool;
    //        // 待完成
    //        判断参数是否为'空'值或非期望的数组类型
    //        if ($Obj == NULL || gettype($Obj) != "array") {
    //            return false;
    //        }
    //
    //        // 判断参数(对象)里面是否包括必须的3个子项
    //        if ($Obj["ID"] == NULL || $Obj["Name"] == NULL || $Obj["Info"] == NULL) {
    //            return false;
    //        }
    //
    //        $Key = $Obj["ID"];
    //        $Name = $Obj["Name"];
    //        // 判断Name是否重复
    //        $NameIDX = $ObjectPool["NameIDX"];
    // 判断当前Name是否有值，有值情况下值对应的ID是否为当前ID，否则就是重复Name，不允许插入
    //        if ($NameIDX[$Name] != NULL && $ObjectPool["NameIDX"][$Obj["Name"]] != $Key) {
    //            return false;
    //        }
    //
    //        // 覆盖新数据
    //        $ObjectPool[$Key] = $Obj;
    //        $ObjectPool["NameIDX"][$Obj["Name"]] = $Key;
    //
    //        return true;
    //    }
    //
    //    // $KeyType = 0 表示根据ID来删除, =1 表示根据Name来删除
    //    // 缺省按ID来删除
    //    funtion Del($Key, $KeyType) {
    //        global $ObjectPool;
    //
    //        $Key = $Obj["ID"];
    //        if($KeyType == 1) {
    //           $Key = $Obj["Name"];
    //        }
    //       //  获取当前删除对象
    //        $Obj = $ObjectPool[$Key];
    //        // 把对应的索引位置置为null
    //        $ObjectPool[$Key] == NULL;
    //        $ObjectPool["NameIDX"][$Obj["Name"]] = NULL;
    //    }
    //
    //    // $KeyType = 0 表示根据ID来查找, =1 表示根据Name来查找
    //    // 缺省按ID来查找
    //    funtion Find($Key, $KeyType) {
    //        global $ObjectPool;
    //        if($KeyType == 0) {
    //             return $ObjectPool[$Key];
    //        } else ($KeyType == 1) {
    //              //获取当前删除对象
    //               $Obj = $ObjectPool[$Key];
    //              $Name = $Obj["Name"];
    //               $NameIDX = $ObjectPool["NameIDX"];
    //              return $NameIDX[$Name];
    //         } else {
    //              return NULL;
    //          }
    //    }
    //
    //
    //4. 自己设计一个'洗牌'算法, 对一副拍好序的扑克牌(52张)进行乱序处理.
    //   算法要求: 可用于算法数据交换的内存只能保存1张牌的数据
    //   1. 对算法进行详细描述和实现
    //   2. 对算法的效果(乱序效果)和效率(需要多少次的交换)进行评估
    //
    //
    //5. 树型列表构建
    //	1. 本题不需要提供源码, 提供程序设计说明和运行结果截图
    //	2. 用于结果截图的测试数据要求:100个左右, 最大层级为4级
    //	3. 程序要求:
    //		0. 开发语言不限, 可以按需要混合使用多种语言
    //		1. 从文件或数据库读入指定格式的行数据
    //		2. 根据下面的树型构造要求进行数据构造
    //		3. 按适当的形式显示已经完成构造的树(可以采用JSON字符)
    //		   ** 如果使用H5在浏览器前端显示可以加分 **
    //		5. 数据规模要求:
    //			1. 总记录数最多10万条
    //			2. 层级深度最大32层
    //		6. 程序运行要求:
    //			1. 在最大数据规模情况下, 总处理时间不超过30秒(按单核计算)
    //			2. 总消耗的内存不能大于100M
    //
    //	4. 数据定义
    //		1. 原始数据为行记录, 格式: id|pid|name|sort
    //			1. id 当前节点id
    //			2. pid 当前节点的父亲id, 0 表示没有父亲
    //			3. name 当前节点的名称
    //			4. sort 当前节点在同层级的节点中的顺序号(小的在前面)
    //		2. id 不可以重复
    //		3. 一个节点可以有0, 1个父亲节点
    //		4. 一个节点可以有0, 1, 多个儿子节点
    //		5. 相同层级, 相同顺序号的节点, 缺省按id排序, 小的在前面
    //
    //	5. 树形结构示例
    //		1. 行数据样例(,表示分行)
    //			1|0|A|0, 2|1|a1|1, 3|1|a2|0, 5|1|a3|0, 6|2|aa1|0,
    //			7|0|E|1, 8|10|b1|0, 10|0|B|0,  20|0|C|0, 21|0|X|0, 100|6|aaa1|2
    //		2. 对应的树形结构
    //			ID:1(Name=A)
    //			  | --> ID:3(Name=a2)
    //			  | --> ID:2(Name=a1)
    //		              | --> ID:6(Name=aa1)
    //		                      | --> ID:100(Name=aaa1)
    //		      | --> ID:5(Name=a3)
    //		    ID:10(Name=B)
    //		      | --> ID:8(Name=b1)
    //		    ID:20(Name=C)
    //		    ID:21(Name=X)
    //		    ID:7(Name=E)

    @Setter
    @Getter
    class TreeNode {
        int id;
        int pid;
        String name;
        int sort;

        List<TreeNode> children;

        TreeNode(int id, int pid, String name, int sort) {
            this.id = id;
            this.pid = pid;
            this.name = name;
            this.sort = sort;
        }

    }

    @Test
    public void printTree() {
        // paramList代表从数据库中获取的行数据，每一行为一个元素，以String格式存储
        List<String> paramList = new ArrayList<>(
                Arrays.asList("1|0|A|0", "2|1|a1|1", "3|1|a2|0", "4|2|aa2|1", "5|1|a3|0", "6|2|aa1|0",
                        "7|0|E|1", "8|10|b1|0", "10|0|B|0",  "20|0|C|0", "21|0|X|0", "100|6|aaa1|2"));
        // 1|0|A|0	构建结构体，id | pid | name |  sort
        List<TreeNode> treeNodeList = new ArrayList<>();
        for (String param : paramList) {
            // 理想情况下，知道字符串会有三条“|”线分割
            String[] split = param.split("\\|");
            treeNodeList.add(new TreeNode(Integer.parseInt(split[0]),Integer.parseInt(split[1]), split[2], Integer.parseInt(split[3])));
        }
        List<TreeNode> pList = treeNodeList.stream().filter(t -> 0 == t.getPid()).collect(Collectors.toList());
        for (TreeNode treeNode : pList) {
            List<TreeNode> childs = treeNodeList.stream().filter(t -> t.getPid() == treeNode.getId())
                    .sorted(Comparator.comparingInt(TreeNode::getSort)).sorted(Comparator.comparingInt(TreeNode::getId)).collect(Collectors.toList());
            treeNode.setChildren(childs);
        }
        List<TreeNode> nodeList = packageMenuTree(pList, treeNodeList);
        for (TreeNode treeNode : nodeList) {
            printTreeB(treeNode, 0);
        }
    }

    private List<TreeNode> packageMenuTree(List<TreeNode> firstMenu, List<TreeNode> treeNodeList) {
        List<TreeNode> menuResults = new ArrayList<>();
        if (null != firstMenu) {
            for (TreeNode treeNode : firstMenu) {
                menuResults.add(treeNode);
                List<TreeNode> childs = treeNodeList.stream().filter(t -> t.getPid() == treeNode.getId())
                        .sorted(Comparator.comparingInt(TreeNode::getSort)).sorted(Comparator.comparingInt(TreeNode::getId)).collect(Collectors.toList());
                treeNode.setChildren(packageMenuTree(childs, treeNodeList));
            }
        }
        return menuResults;
    }

    private void printTreeB(TreeNode node, int size) {
        StringBuilder pre = new StringBuilder();
        String blank = "	";
        for (int i = 0; i < size; i++) {
            pre.append(blank);
        }
        if (size!=0) {
            pre.append("| --> ");
        }
        pre.append("ID:").append(node.getId()).append("(Name=").append(node.getName()).append(")");
        System.out.println(pre.toString());
        ++size;
        if (node.getChildren() != null) {
            for (TreeNode child : node.getChildren()) {
                printTreeB(child, size);
            }
        }
    }

}
