package jp.harujioh.endian.little;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jp.harujioh.endian.LittleEndianUtil;

/**
 * リトルエンディアンutilクラスのshort値テスト
 * 
 * @author rhirata
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LittleEndianShortTest {

	/**
	 * 2byteからshort値を生成
	 * 
	 * @param b1
	 * @param b2
	 * @return
	 */
	public static short get(int b1, int b2) {
		return (short) ((b1 << 8) | b2);
	}

	/**
	 * 配列長とバイト長が同じバッファから取得するテスト
	 */
	@Test
	public void getTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01, 0x23 }), //
				is(get(0x23, 0x01)));
	}

	/**
	 * 配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getNotEnoughTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01 }), //
				is(get(0x01, 0x00)));
	}

	/**
	 * 配列長がバイト長より大きいバッファから取得するテスト
	 */
	@Test
	public void getEnoughTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89 }), //
				is(get(0x23, 0x01)));
	}

	/**
	 * バッファからoffsetを指定して取得するテスト
	 */
	@Test
	public void getOffsetTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 2), //
				is(get(0x67, 0x45)));
	}

	/**
	 * バッファからoffsetを指定するが、それ以降の配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getOffsetNotEnoughLengthTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 7), //
				is(get(0xef, 0x00)));
	}

	/**
	 * バッファからoffsetとlengthを指定して取得するテスト
	 */
	@Test
	public void getOffsetLengthTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01, 0x23, 0x45, 0x67, 0x89, 0xab, 0xcd, 0xef }, 3, 1), //
				is(get(0x67, 0x00)));
	}

	/**
	 * バッファからoffsetとlengthを指定するが、それ以降の配列長がバイト長より小さいバッファから取得するテスト
	 */
	@Test
	public void getOffsetLengthNotEnoughLengthTest() {
		assertThat( //
				LittleEndianUtil.getShort(new int[] { 0x01, 0x23, 0x45, 0x67 }, 3, 1), //
				is(get(0x67, 0x00)));
	}
}
