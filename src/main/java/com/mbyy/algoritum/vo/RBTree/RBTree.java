package com.mbyy.algoritum.vo.RBTree;


public class RBTree<T extends Comparable<T>> {
    private RBNode<T> mRoot;     //根节点

    public RBTree() {
        mRoot = null;
    }

    private RBNode<T> parentOf(RBNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBNode<T> node) {
        return node != null ? node.color : RBNode.BLACK;
    }

    private boolean isRed(RBNode<T> node) {
        return ((node != null) && (node.color == RBNode.RED)) ? true : false;
    }

    private boolean isBlack(RBNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBNode<T> node) {
        if (node != null) {
            node.color = RBNode.BLACK;
        }
    }

    private void setRed(RBNode<T> node) {
        if (node != null) {
            node.color = RBNode.RED;
        }
    }

    private void setParent(RBNode<T> node, RBNode<T> parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private void setColor(RBNode<T> node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    /*
     * 前序遍历红黑树
     * */
    private void preOrder(RBNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍历红黑树
     * */
    private void inOrder(RBNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    /*
     * 后序遍历红黑树
     * */
    private void postOrder(RBNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    public void postOrder() {
        postOrder(mRoot);
    }

    /*
     * 查找红黑树x中键值为key的节点(递归实现)
     * */
    private RBNode<T> search(RBNode<T> x, T key) {
        if (x == null)
            return x;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return search(x.left, key);
        } else if (cmp > 0) {
            return search(x.right, key);
        } else
            return x;
    }

    public RBNode<T> search(T key) {
        return search(mRoot.key);
    }

    /*
     * 查找红黑树x中键值为key的节点(非递归实现)
     * */
    private RBNode<T> iterativeSearch(RBNode<T> x, T key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0)
                x = x.left;
            else if (cmp > 0)
                x = x.right;
            else
                return x;
        }
        return x;
    }

    public RBNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    //查找最小节点,返回tree为根节点的红黑树的最小节点
    private RBNode<T> minimum(RBNode<T> tree) {
        if (tree == null)
            return null;
        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        RBNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }
        return null;
    }


    /*
     *    左旋代码
     *       px                     px
     *       /                      /
     *      x                      y
     *     / \                    / \
     *    lx y      --(左旋)-->   x  ry
     *      / \                 / \
     *     ly ry              lx ly
     *
     * */
    private void leftRotate(RBNode<T> x) {
        //设置右孩子为y
        RBNode<T> y = x.right;

        //将“y的左孩子”设为“x的右孩子”
        //如果y的左孩子非空，将“x”设为“y的左孩子的父亲”
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }

        //将“x的父亲”设为“y的父亲”
        y.parent = x.parent;

        if (x.parent == null) {
            this.mRoot = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }

        //将“x”设为“y的左孩子”
        y.left = x;
        //将“x的父节点”设为“y”
        x.parent = y;
    }

    /*
     * 查找最大结点：返回tree为根结点的红黑树的最大结点。
     */
    private RBNode<T> maximum(RBNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        RBNode<T> p = maximum(mRoot);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * 找结点(x)的后继结点。即，查找"红黑树中数据值大于该结点"的"最小结点"。
     */
    public RBNode<T> successor(RBNode<T> x) {
        // 如果x存在右孩子，则"x的后继结点"为 "以其右孩子为根的子树的最小结点"。
        if (x.right != null)
            return minimum(x.right);

        // 如果x没有右孩子。则x有以下两种可能：
        // (01) x是"一个左孩子"，则"x的后继结点"为 "它的父结点"。
        // (02) x是"一个右孩子"，则查找"x的最低的父结点，并且该父结点要具有左孩子"，找到的这个"最低的父结点"就是"x的后继结点"。
        RBNode<T> y = x.parent;
        while ((y != null) && (x == y.right)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /*
     * 找结点(x)的前驱结点。即，查找"红黑树中数据值小于该结点"的"最大结点"。
     */
    public RBNode<T> predecessor(RBNode<T> x) {
        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (x.left != null)
            return maximum(x.left);

        // 如果x没有左孩子。则x有以下两种可能：
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        RBNode<T> y = x.parent;
        while ((y != null) && (x == y.left)) {
            x = y;
            y = y.parent;
        }

        return y;
    }

    /*
     *    右旋代码
     *       px                     px
     *       /                      /
     *      x                      y
     *     / \                    / \
     *    lx y     <---(右旋)--   x  ry
     *      / \                 / \
     *     ly  ry              lx ly
     *
     * */
    private void rightRotate(RBNode<T> y) {
        //设置x为当前节点的左孩子
        RBNode<T> x = y.left;

        //将“x的右孩子”设为“y的左孩子”
        //如果x的右孩子非空，将“y”设为“x的右孩子的父亲”
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }

        //将“y的父亲”设为“x的父亲”
        x.parent = y.parent;

        if (y.parent == null) {
            this.mRoot = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }

        //将“y”设为“x的右孩子”
        x.right = y;
        //将“y的父节点”设为“x”
        y.parent = x;
    }

    /*
     * 将节点插入到红黑树中
     *
     * 第一步：将红黑树当做一颗二叉查找树，将结点插入
     * 第二步：将插入的节点着色为”红色“
     * 第三步：通过一系列的宣传或着色等操作，使之重新成为一颗红黑树
     * @param node 插入的节点
     * */
    private void insert(RBNode<T> node) {
        int cmp;
        RBNode<T> y = null;
        RBNode<T> x = this.mRoot;
        //第一步
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left=node;
            } else {
                y.right=node;
            }
        } else {
            this.mRoot = node;
        }

        //第二步
        node.color = RBNode.RED;
        //第三步
        insertFixUp(node);
    }

    /*
     * 新建节点，并把它插入到红黑树中
     *
     *  @Param key:插入节点的键值
     * */
    public void insert(T key) {
        RBNode<T> node = new RBNode<T>(key, RBNode.BLACK, null, null, null);

        //如果新建节点失败，则返回
        if (node != null) {
            insert(node);
        }
    }

    /*
     * 红黑树插入修正函数
     *
     * 在向红黑树插入节点之后（失去平衡），在调用该函数
     * 目的是把它重新塑造成一颗红黑树
     *
     * @param node:插入的节点
     * */
    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent;

        // 若“父节点存在，并且父节点的颜色是红色”
        while (((parent = parentOf(node)) != null) && (isRed(parent))) {
            gparent = parentOf(parent);
            //若“父节点”是“祖父节点的左孩子”
            if (parent == gparent.left) {
                // Case 1条件：叔叔节点是红色
                RBNode<T> uncle = gparent.right;
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case 2条件：叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    RBNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {    //若“z的父节点”是“z的祖父节点的右孩子”
                // Case 1条件：叔叔节点是红色
                RBNode<T> uncle = gparent.left;
                if ((uncle != null) && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    RBNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }

        //将根节点设置为黑色
        setBlack(this.mRoot);
    }

    /*
     * 红黑树删除修正函数
     *
     * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     *
     * 参数说明：
     *     node 待修正的节点
     */
    private void removeFixUp(RBNode<T> node, RBNode<T> parent) {
        RBNode<T> other;

        while ((node == null || isBlack(node)) && (node != this.mRoot)) {
            if (parent.left == node) {
                other = parent.right;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.right == null || isBlack(other.right)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.mRoot;
                    break;
                }
            } else {

                other = parent.left;
                if (isRed(other)) {
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.left == null || isBlack(other.left)) {
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.mRoot;
                    break;
                }
            }
        }

        if (node != null)
            setBlack(node);
    }

    /*
     * 删除结点(node)，并返回被删除的结点
     *
     * 参数说明：
     *     node 删除的结点
     */
    private void remove(RBNode<T> node) {
        RBNode<T> child, parent;
        boolean color;

        // 被删除节点的"左右孩子都不为空"的情况。
        if ((node.left != null) && (node.right != null)) {
            // 被删节点的后继节点。(称为"取代节点")
            // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
            RBNode<T> replace = node;

            // 获取后继节点
            replace = replace.right;
            while (replace.left != null)
                replace = replace.left;

            // "node节点"不是根节点(只有根节点不存在父节点)
            if (parentOf(node) != null) {
                if (parentOf(node).left == node)
                    parentOf(node).left = replace;
                else
                    parentOf(node).right = replace;
            } else {
                // "node节点"是根节点，更新根节点。
                this.mRoot = replace;
            }

            // child是"取代节点"的右孩子，也是需要"调整的节点"。
            // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
            child = replace.right;
            parent = parentOf(replace);
            // 保存"取代节点"的颜色
            color = colorOf(replace);

            // "被删除节点"是"它的后继节点的父节点"
            if (parent == node) {
                parent = replace;
            } else {
                // child不为空
                if (child != null)
                    setParent(child, parent);
                parent.left = child;

                replace.right = node.right;
                setParent(node.right, replace);
            }

            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;

            if (color == RBNode.BLACK)
                removeFixUp(child, parent);

            node = null;
            return;
        }

        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        // 保存"取代节点"的颜色
        color = node.color;

        if (child != null)
            child.parent = parent;

        // "node节点"不是根节点
        if (parent != null) {
            if (parent.left == node)
                parent.left = child;
            else
                parent.right = child;
        } else {
            this.mRoot = child;
        }

        if (color == RBNode.BLACK)
            removeFixUp(child, parent);
        node = null;
    }

    /*
     * 删除结点(z)，并返回被删除的结点
     *
     * 参数说明：
     *     tree 红黑树的根结点
     *     z 删除的结点
     */
    public void remove(T key) {
        RBNode<T> node;

        if ((node = search(mRoot, key)) != null)
            remove(node);
    }

    /*
     * 销毁红黑树
     */
    private void destroy(RBNode<T> tree) {
        if (tree == null)
            return;

        if (tree.left != null)
            destroy(tree.left);
        if (tree.right != null)
            destroy(tree.right);

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    /*
     * 打印"红黑树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(RBNode<T> tree, T key, int direction) {

        if (tree != null) {

            if (direction == 0)    // tree是根节点
                System.out.printf("%2d(B) is root\n", tree.key);
            else                // tree是分支节点
                System.out.printf("%2d(%s) is %2d's %6s child\n", tree.key, isRed(tree) ? "R" : "B", key, direction == 1 ? "right" : "left");

            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }

    public void print() {
        if (mRoot != null)
            print(mRoot, mRoot.key, 0);
    }
}
