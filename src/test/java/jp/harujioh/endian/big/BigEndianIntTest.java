package jp.harujioh.endian.big;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jp.harujioh.endian.BigEndianUtil;

/**
 * ビッグエンディアンutilクラスのint値テスト
 * 
 * @author rhirata
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BigEndianIntTest {

	/**
	 * 4byteからint値を生成
	 * 
	 * @param b1
	 * @param b2
	 * @param b3
	 * @param b4
	 * @return
	 */
	public static int get(int b1, int b2, int b3, int b4) {
		return (b1 << 24) | (b2 << 16) | (b3 << 8) | b4;
	}

	/**
	 * 配列長とバイト長が同じバッファから取得するテスト
	 */
	@Test
	public void getTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23, 0x45, 0x67 }), //
				is(get(0x01, 0x23, 0x45, 0x67)));
	}

	/**
	 * 配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getNotEnoughTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23 }), //
				is(get(0x00, 0x00, 0x01, 0x23)));
	}

	/**
	 * 配列長がバイト長より大きいバッファから取得するテスト
	 */
	@Test
	public void getEnoughTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89 }), //
				is(get(0x01, 0x23, 0x45, 0x67)));
	}

	/**
	 * バッファからoffsetを指定して取得するテスト
	 */
	@Test
	public void getOffsetTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 2), //
				is(get(0x45, 0x67, 0x89, 0xab)));
	}

	/**
	 * バッファからoffsetを指定するが、それ以降の配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getOffsetNotEnoughLengthTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 6), //
				is(get(0x00, 0x00, 0xcd, 0xef)));
	}

	/**
	 * バッファからoffsetとlengthを指定して取得するテスト
	 */
	@Test
	public void getOffsetLengthTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 3, 3), //
				is(get(0x00, 0x67, 0x89, 0xab)));
	}

	/**
	 * バッファからoffsetとlengthを指定するが、それ以降の配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getOffsetLengthNotEnoughLengthTest() {
		assertThat( //
				BigEndianUtil.getInt(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab }, 3, 2), //
				is(get(0x00, 0x00, 0x67, 0x89)));
	}
}
