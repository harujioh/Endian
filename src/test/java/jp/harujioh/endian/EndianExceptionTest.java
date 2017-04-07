package jp.harujioh.endian;

import org.junit.Test;

import jp.harujioh.endian.EndianUtil;

/**
 * エンディアンutilクラスのExceptionテスト
 * 
 * @author rhirata
 */
public class EndianExceptionTest {

	/**
	 * offsetが負の値のテスト
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void getOffsetMinusTest() {
		EndianUtil.createByteBuffer(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, -2, 4, 4);
	}

	/**
	 * offsetが配列長さを超えるテスト
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void getOffsetOverflowTest() {
		EndianUtil.createByteBuffer(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 10, 4, 4);
	}

	/**
	 * lengthが負の値のテスト
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void getOffsetLengthMinusTest() {
		EndianUtil.createByteBuffer(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 5, -1, 4);
	}

	/**
	 * lengthがバイト長を超えるテスト
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void getIntOffsetLengthOverflowTest() {
		EndianUtil.createByteBuffer(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 5, 5, 4);
	}
}
