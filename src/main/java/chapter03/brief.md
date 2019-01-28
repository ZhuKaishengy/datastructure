##算法的时间复杂度和空间复杂度
1. 如何衡量算法的优劣？
* 事后统计： 和运行程序的机器本身有很大关系
* 事前估算： 时间复杂度和空间复杂度

2. 大部分时候不考虑空间复杂度，时间复杂度越低，算法越优秀
3. 语句频度 T(n): 一个算法中语句执行次数
4. T(n) = O(f(n)) T(n)/f(n) 的极限为不为0的常数
eg： T(n) = n^2 + n + 1 T(n) = 3n^2 
其时间复杂度相同 O(n^2)