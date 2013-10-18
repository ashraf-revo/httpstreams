package github.chenxh.media.flv.tags;

import java.io.EOFException;
import java.io.IOException;

import github.chenxh.media.IDataTrunk;
import github.chenxh.media.UnsignedDataInput;
import github.chenxh.media.flv.FlvSignature;
import github.chenxh.media.flv.ITagTrunk;
import github.chenxh.media.flv.ITagData;
import github.chenxh.media.flv.ITagDataVistor;
import github.chenxh.media.flv.ITagHead;

public class TagDataVistorAdapter  implements ITagDataVistor {

    public TagDataVistorAdapter() {
        super();
    }

    @Override
    public ITagData readScriptData(FlvSignature flv, ITagHead header, UnsignedDataInput inStream) throws IOException {
        return skipDatas(header, inStream);
    }

    @Override
    public ITagData readAudioData(FlvSignature flv, ITagHead header, UnsignedDataInput inStream) throws IOException {
        return skipDatas(header, inStream);
    }

    @Override
    public ITagData readOtherData(FlvSignature flv, ITagHead header, UnsignedDataInput inStream) throws IOException {
        return skipDatas(header, inStream);
    }

    @Override
    public ITagData readVideoData(FlvSignature signature, ITagHead header, UnsignedDataInput inStream) throws IOException {
        return skipDatas(header, inStream);
    }

    /**
     * ��������
     * 
     * @param header
     * @param inStream
     * @return
     * @throws IOException
     */
    protected ITagData skipDatas(IDataTrunk header, UnsignedDataInput inStream) throws IOException {
        inStream.skipBytes(header.getDataSize());
        return null;
    }

    public boolean interruptAfterSignature(FlvSignature signature) throws IOException, EOFException {
        return false;
    }
    
    @Override
    public boolean interruptAfterTag(ITagTrunk tag) throws IOException, EOFException {
        return false;
    }
}