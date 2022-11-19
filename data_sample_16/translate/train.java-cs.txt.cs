public static DVConstraint CreateExplicitListConstraint(String[] explicitListValues){return new DVConstraint(null, explicitListValues);}
public override String ToString(){StringBuilder buffer = new StringBuilder();buffer.Append("[SCL]\n");buffer.Append("    .numerator            = ").Append("0x").Append(HexDump.ToHex(Numerator)).Append(" (").Append(Numerator).Append(" )");buffer.Append(Environment.NewLine);buffer.Append("    .denominator          = ").Append("0x").Append(HexDump.ToHex(Denominator)).Append(" (").Append(Denominator).Append(" )");buffer.Append(Environment.NewLine);buffer.Append("[/SCL]\n");return buffer.ToString();}
public UDFFinder GetUDFFinder(){return _uBook.GetUDFFinder();}
public void Reset(int point){this.point = point;ends.count = 0;starts.count = 0;}
public override void write(string str, int offset, int count){write(Sharpen.StringHelper.Substring(str, offset, offset + count).ToCharArray());}
public void AddRecords(RecordStream rs){while (true){if (!ReadARecord(rs)){break;}}}
public virtual ListStackSetsResponse ListStackSets(ListStackSetsRequest request){var options = new InvokeOptions();options.RequestMarshaller = ListStackSetsRequestMarshaller.Instance;options.ResponseUnmarshaller = ListStackSetsResponseUnmarshaller.Instance;return Invoke<ListStackSetsResponse>(request, options);}
public virtual void SetCollector(ICollector collector){this.collector = collector;}
public override string ToString(){if (NoBreak == null && PostBreak == null && PreBreak != null && PreBreak.Equals("-", StringComparison.Ordinal)){return "-";}StringBuilder res = new StringBuilder("{");res.Append(PreBreak);res.Append("}{");res.Append(PostBreak);res.Append("}{");res.Append(NoBreak);res.Append('}');return res.ToString();}
public virtual DescribeRegionsResponse DescribeRegions(){return DescribeRegions(new DescribeRegionsRequest());}
public override Object Clone(){VCenterRecord rec = new VCenterRecord();rec.field_1_vcenter = field_1_vcenter;return rec;}
public AutomatonQuery(Term term, Automaton automaton): base(term.Field){this.m_term = term;this.m_automaton = automaton;this.m_compiled = new CompiledAutomaton(automaton);}
public override string ToString(){return GetType().Name + "[" + GetFile().GetPath() + "]";}
public virtual void FromRaw(int[] ints, int p){w1 = ints[p];w2 = ints[p + 1];w3 = ints[p + 2];w4 = ints[p + 3];w5 = ints[p + 4];}
public void Remove(int index){CheckIndex(index);_mergedRegions.RemoveAt(index);}
public virtual int size(){return mSize;}
