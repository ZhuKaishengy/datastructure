package chapter04;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * 哈夫曼编码
 */
public class HuffmanCode {

    /**
     * 内部类：赫夫曼树节点
     */
    @Data
    @Accessors(chain = true)
    private class HuffmanNode {
        private int weight;
        private Byte content;
        private HuffmanNode lChild;
        private HuffmanNode rChild;
    }

    /**
     * 使用赫夫曼编码压缩文件
     * @param src
     * @param dst
     */
    public void zipFile(String src, String dst) throws IOException {
        // 读取
        FileInputStream is = new FileInputStream(src);
        byte[] content = new byte[is.available()];
        is.read(content);
        byte[] bytes = this.huffmanZip(content);
        // 写入
        FileOutputStream fos = new FileOutputStream(dst);
        // 压缩率
        double len1 = content.length;
        double len2 = bytes.length;
        System.out.println("rate:" + (len1 / len2) * 100 + " %");
        fos.write(bytes);
        is.close();
    }

    /**
     * 赫夫曼编码解压
     * @param src
     * @param dst
     */
    public void unZipFile(String src, String dst, Map<Byte, String> huffmanCodeMap) throws IOException {
        // 读取
        FileInputStream is = new FileInputStream(src);
        byte[] content = new byte[is.available()];
        is.read(content);
        byte[] decode = this.decode(content, huffmanCodeMap);
        // 写入
        FileOutputStream fos = new FileOutputStream(dst);
        // 压缩率
        double len1 = content.length;
        double len2 = decode.length;
        System.out.println("rate:" + (len1 / len2) * 100 + " %");
        fos.write(decode);
        is.close();
    }

    /**
     * 通过编码表进行解码
     * @param binary
     * @param huffmanCodeMap
     * @return
     *
     * 1111000011100011001110110011111000011001111100001101101010110011111000011111000001101111101000111110000110011111000
     * 97:1 ...
     */
    public byte[] decode(byte[] binary, Map<Byte, String> huffmanCodeMap) {
        // 将十进制转为8位二进制字符串
        StringBuilder tmp = new StringBuilder();
        for (byte b : binary) {
            String s;
            if (b == binary[binary.length - 1]){
                // 最后一个不转换
                s = this.toBitBinaryString(b, lastBit);
            } else{

               s = this.toBitBinaryString(b,8);
            }
            tmp.append(s);
        }
        String binaryStr = tmp.toString();
        System.out.println(binaryStr);
        // 将重新拼接的二进制字符串按照huffman编码表进行解码
        StringBuilder sb = new StringBuilder();
        while (binaryStr.length() > 0) {
            for (Map.Entry<Byte, String> entry : huffmanCodeMap.entrySet()) {
                byte key = entry.getKey();
                String value = entry.getValue();
                char c = (char) key;
                if (binaryStr.startsWith(value)) {
                    // find it
                    binaryStr = binaryStr.substring(value.length());
                    sb.append(c);
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString().getBytes();
    }

    /**
     * 将十进制转为bit位二进制字符串
     * @param i 32位int的数字
     * @param bit 需要转换的位数
     * @return 8位二进制的数字
     */
    public String toBitBinaryString(int i, int bit){

        Double pow = Math.pow(2, bit);
        i |= pow.intValue();
        String s1 = Integer.toBinaryString(i);
        return s1.substring(s1.length() - bit);
    }

    /**
     * 赫夫曼编码表
     */
    private static Map<Byte, String> huffmanCodeMap = null;
    /**
     * 将一个字符串转为赫夫曼编码
     * @param input
     * @return
     */
    public byte[] huffmanZip (byte[] input){

        // 统计每个ascII码出现的次数
        Map<Byte, Integer> byteMap = this.statisticsByteCount(input);
        System.out.println(byteMap);
        // 将 bytemap 转为 nodes 集合
        List<HuffmanNode> nodes = this.getNodes(byteMap);
        // 根据出现次数创建赫夫曼树
        HuffmanNode root = this.createHuffmanTree(nodes);
        // 创建赫夫曼编码表，一个byte对应一串01字符
        huffmanCodeMap = this.createHuffmanCode(root);
        // 根据编码表进行编码
        return this.zip(input, huffmanCodeMap);
    }

    /**
     * 二进制字符串最后一个的字符数
     */
    private static int lastBit = 0;

    private byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodeMap) {
        // 获取二进制的string串
        StringBuffer sb = new StringBuffer();
        for (byte aByte : bytes) {
            String binaryStr = huffmanCodeMap.get(aByte);
            sb.append(binaryStr);
        }
        System.out.println(sb.toString());
        // 将此字符串8位一组，转成byte[]
        byte[] by = new byte[(sb.toString().length() + 7) >> 3];
        int index = 0;
        for (int i = 0; i < sb.toString().length(); i+=8) {

            String binarySubstr ;
            if (i + 8 < sb.toString().length()) {
                binarySubstr = sb.toString().substring(i, i + 8);
            } else {
                binarySubstr = sb.toString().substring(i);
                lastBit = sb.toString().length() - i;
            }
            byte b = (byte) Integer.parseInt(binarySubstr, 2);
            by[index] = b;
            index ++;
        }
        return by;
    }

    Map<Byte,String> huffmanCode = new HashMap<>();


    private Map<Byte, String> createHuffmanCode(HuffmanNode root) {
        if (root == null) {
            return null;
        }
        if (root.getLChild() != null) {
            getCodes(root.getLChild(), 0, new StringBuffer());
        }
        if (root.getRChild() != null) {
            getCodes(root.getRChild(), 1, new StringBuffer());
        }
        return huffmanCode;
    }

    private void getCodes(HuffmanNode node, int star, StringBuffer preLevelSb) {

        StringBuffer sb1 = new StringBuffer(preLevelSb);
        sb1.append(star);
        if (node.getContent() == null) {
            // 非叶子节点
            if (node.getLChild() != null) {
                this.getCodes(node.getLChild(), 0, sb1);
            }
            if (node.getRChild() != null) {
                this.getCodes(node.getRChild(), 1, sb1);
            }
        } else {
            huffmanCode.put(node.getContent(), sb1.toString());
        }
    }


    private HuffmanNode createHuffmanTree(List<HuffmanNode> nodes) {

        // 排序找到 最小的 两个节点
        nodes.sort(Comparator.comparingInt(HuffmanNode::getWeight));
        // 创建非叶子节点，替换那两个节点
        HuffmanNode huffmanNode1 = nodes.get(0);
        HuffmanNode huffmanNode2 = nodes.get(1);
        HuffmanNode huffmanNode = new HuffmanNode().setWeight(huffmanNode1.getWeight() + huffmanNode2.getWeight())
                .setLChild(huffmanNode1).setRChild(huffmanNode2);
        nodes.remove(huffmanNode1);
        nodes.remove(huffmanNode2);
        nodes.add(huffmanNode);
        // 重新排序，递归
        if (nodes.size() > 1) {
            createHuffmanTree(nodes);
        }
        return nodes.get(0);
    }

    private List<HuffmanNode> getNodes(Map<Byte, Integer> byteMap) {

        List<HuffmanNode> nodes = new ArrayList<>(byteMap.size());
        for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()) {
            HuffmanNode node = new HuffmanNode().setContent(entry.getKey()).setWeight(entry.getValue());
            nodes.add(node);
        }
        return nodes;
    }


    private Map<Byte, Integer> statisticsByteCount(byte[] bytes) {
        Map<Byte, Integer> byteMap = new HashMap<>();
        for (byte aByte : bytes) {
            Integer count = byteMap.get(aByte);
            if (byteMap.containsKey(aByte)) {
                byteMap.put(aByte, count + 1);
                continue;
            }
            byteMap.put(aByte, 1);
        }
        return byteMap;
    }

    public static void main(String[] args) throws IOException {
        HuffmanCode huffmanCode = new HuffmanCode();
//      压缩字符串
//        String str = "can you can a can as a can canner can a can";
//        System.out.println("source:" + Arrays.toString(str.getBytes()));
//        byte[] huffmanZip = huffmanCode.huffmanZip(str.getBytes());
//        System.out.println("ziped:" + Arrays.toString(huffmanZip));
//
//        // 测试解码
//        byte[] decode = huffmanCode.decode(huffmanZip, huffmanCodeMap);
//        System.out.println("decoded:" + Arrays.toString(decode));
//
//        // 压缩率
//        double countBefore = str.getBytes().length;
//        double countAfter = huffmanZip.length;
//        double rate = countAfter / countBefore ;
//        System.out.println(rate * 100 + "%");

//        压缩文件
        huffmanCode.zipFile("/Users/zhukaishengy/Desktop/fillActiveTime.js", "/Users/zhukaishengy" +
                "/Desktop/1.zip");

        huffmanCode.unZipFile("/Users/zhukaishengy/Desktop/1.zip", "/Users/zhukaishengy/Desktop/haha.js", huffmanCodeMap);


    }
}
